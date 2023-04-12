public class MergingThreaded extends Thread {
    private int[] subList1;
    private int[] subList2;
    private int startIndex1;
    private int startIndex2;
    public MergingThreaded(int[] subList1, int[] subList2, int startIndex1, int startIndex2) {
        this.subList1 = subList1;
        this.subList2 = subList2;
        this.startIndex1 = startIndex1;
        this.startIndex2 = startIndex2;
    }

    @Override
    public void run() {
        // Merge the two sorted sub lists into the global sorted array
        int i = 0, j = 0, k = 0;
        while (i < subList1.length && j < subList2.length) {
            if (subList1[i] < subList2[j]) {
                MultiThreadedSorting.sortedArray[k] = subList1[i];
                i++;
            } else {
                MultiThreadedSorting.sortedArray[k] = subList2[j];
                j++;
            }
            k++;
        }

        // Add the remaining elements from sub list 1
        while (i < subList1.length) {
            MultiThreadedSorting.sortedArray[k] = subList1[i];
            i++;
            k++;
        }

        // Add the remaining elements from sub list 2
        while (j < subList2.length) {
            MultiThreadedSorting.sortedArray[k] = subList2[j];
            j++;
            k++;
        }
    }
}
