import java.util.Random;

public class BubbleSort {
    public static void fillArrayWithRandom(int[] arr, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt((max - min) + 1) + min;
        }
    }

    public static void main(String[] args) {
        // Initialize the array to be sorted
        int[] arr = new int[5000];
        fillArrayWithRandom(arr,1,1000);
        // Perform the bubble sort
        long inputStart = System.currentTimeMillis();
        int size = arr.length;
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        long inputEnd = System.currentTimeMillis();

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Time taken in milliseconds: " +(inputEnd-inputStart)+"\n\n");
    }
}