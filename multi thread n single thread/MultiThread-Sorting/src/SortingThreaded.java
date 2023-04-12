public class SortingThreaded extends Thread {
    private int[] subList;
    private int startIndex;

    public SortingThreaded(int[] subList, int startIndex) {
        this.subList = subList;
        this.startIndex = startIndex;
    }

    @Override
    public void run() {
        // Sort the sub list using bubble sort
        int size = subList.length;
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-i-1; j++) {
                if (subList[j] > subList[j+1]) {
                    int temp = subList[j];
                    subList[j] = subList[j+1];
                    subList[j+1] = temp;
                }
            }
        }
    }
}

