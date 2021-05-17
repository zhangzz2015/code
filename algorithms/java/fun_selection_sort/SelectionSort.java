import java.util.Arrays;

public class SelectionSort {
    public void selectionSort(int[] array) {
        // sanity check
        if (array == null || array.length <= 1) {
            return array;
        }
        int len = array.length;
		for (int i = 1; i < len; i++) {
			int cur = array[i];
			int j = i - 1
			for (; j >= 0; j--) {
				if (array[j] > cur) {
					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = cur;
		}
    }
	
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = null;
        selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));
        
        array = new int[0];
        selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));
        
        array = new int[] {1, 2, 3, 4};
        selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {4, 3, 2, 1};
        selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {2, 4, 1, 5, 3};
        selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
