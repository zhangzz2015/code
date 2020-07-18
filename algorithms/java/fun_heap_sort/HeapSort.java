import java.util.Arrays;

public class HeapSort {
    public void heapSort(int[] array) {
        // sanity check
        if (array == null || array.length <= 1) return;
        int len = array.length;
        heapify(array);
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, 0, i);
            percolateDown(array, 0, i);
        }
    }

    private void heapify(int[] array) {
        int len = array.length;
        for (int i = len / 2 - 1; i >= 0; i--) { // because -1 / 2 = 0, we need to use len / 2 - 1 
            percolateDown(array, i, len);
        }
    }

    private void percolateDown(int[] array, int index, int len) {
        while (index <= len / 2 - 1) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int max = index;
            if (array[left] > array[max]) {
                max = left;
            }
            if (right < len && array[right] > array[max]) {
                max = right;
            }
            if (max == index) {
                break;
            }
            swap(array, index, max);
            index = max;
        }
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        int[] input1 = {4, 2, 3, 1};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(input1);
        System.out.println(Arrays.toString(input1));
        System.out.println("***********");
        int[] input2 = {4, 2, 3, 1, -1, 10, 20};
        heapSort.heapSort(input2);
        System.out.println(Arrays.toString(input2));
    }
}