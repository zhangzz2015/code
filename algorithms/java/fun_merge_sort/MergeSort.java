public class MergeSort {

    public int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        return mergeSort(array, 0, array.length - 1);
    }
    private int[] mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return new int[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftResult = mergeSort(array, left, mid);
        int[] rightResult = mergeSort(array, mid + 1, right);
        return merge(leftResult, rightResult);
    }
    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length)  {
            if (left[leftIndex] <= right[rightIndex]) {
                res[resIndex] = left[leftIndex];
                leftIndex++;
            } else {
                res[resIndex] = right[rightIndex];
                rightIndex++;
            }
            resIndex++;
        }
        while (leftIndex < left.length) {
            res[resIndex] = left[leftIndex];
            leftIndex++;
            resIndex++;
        }
        while (rightIndex < right.length) {
            res[resIndex] = right[rightIndex];
            rightIndex++;
            resIndex++;
        }
        return res;
    }

    // space optimize
    public int[] mergeSort1(int[] array) {
        if (array == null) return array;
        // allocate helper array to help merge step
        // so that we guarantee no more than O(n) space is used
        int[] helper = new int[array.length];
        mergeSort1(array, helper, 0, array.length - 1);
        return array;
    }

    private void mergeSort1(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort1(array, helper, left, mid);
        mergeSort1(array, helper, mid + 1, right);
        merge1(array, helper, left, mid, right);
    }

    private void merge1(int[] array, int[] helper, int left, int mid, int right) {
        // copy the content to helper array and use helper to merge
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
        // no need to copy the elements on the right, they are already in their position
    }
}