import java.util.Arrays;
import java.util.Random;

public class MultiThreadedSorting {
    // Initialize the global array and sorted array
    public static int[] globalArray;
    public static int[] sortedArray;

    public static void fillArrayWithRandom(int[] arr, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((max - min) + 1) + min;
        }
    }

    public static void main(String[] args) {
        globalArray = new int[5000];
        fillArrayWithRandom(globalArray,1,1000);
        sortedArray = new int[globalArray.length];

        // Divide the global array into two sub lists
        int[] subList1 = Arrays.copyOfRange(globalArray, 0, globalArray.length/2);
        int[] subList2 = Arrays.copyOfRange(globalArray, globalArray.length/2, globalArray.length);

        // Create two sorting threads, one for each sub list
        Thread sortingThread1 = new Thread(new SortingThreaded(subList1, 0));
        Thread sortingThread2 = new Thread(new SortingThreaded(subList2, globalArray.length/2));

        // Start the sorting threads
        long Start = System.currentTimeMillis();
        sortingThread1.start();
        sortingThread2.start();

        // Wait for the sorting threads to finish
        try {
            sortingThread1.join();
            sortingThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create a merging thread to merge the two sorted sub lists
        Thread mergingThread = new Thread(new MergingThreaded(subList1, subList2, 0, globalArray.length/2));

        // Start the merging thread
        mergingThread.start();

        // Wait for the merging thread to finish
        try {
            mergingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long End = System.currentTimeMillis();

        // Output the sorted array
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Time taken in milliseconds: " +(End-Start)+"\n\n");
    }
}

