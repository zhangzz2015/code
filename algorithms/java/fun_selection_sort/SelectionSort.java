import java.util.Arrays;

public class SelectionSort {
    public int[] selectionSort(int[] array) {
        // sanity check
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
        return array;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = null;
        array = selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));
        
        array = new int[0];
        array = selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));
        
        array = new int[] {1, 2, 3, 4};
        array = selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {4, 3, 2, 1};
        array = selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {2, 4, 1, 5, 3};
        array = selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}