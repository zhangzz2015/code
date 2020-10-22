class HIndex {

    // quick select
    public int hIndex1(int[] citations) {
        int length = citations.length;
        int left = 0;
        int right = length - 1;
        int res = 0;
        while (left <= right) {
            int pivot = partition(citations, left, right);
            if (length - pivot <= citations[pivot]) {
                res = length - pivot;
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return res;
    }
    private int partition(int[] array, int left, int right) {
        int pivotIndex = left + (int)(Math.random() * (right - left + 1));
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            } else if (array[right] >= pivot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // bucket sort
    public int hIndex2(int[] citations) {
        if (citations.length == 0) return 0;
        // need one more bucket for the numbers that are larger than length
        int[] counts = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length) {
                counts[citations.length] += 1;
            } else {
                counts[citations[i]] += Math.min(1, citations[i]);
            }
        }
        int citationCount = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            citationCount += counts[i];
            if (i <= citationCount) {
                return i;
            }
        }
        return -1;
    }
}