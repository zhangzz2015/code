import java.util.Arrays;

public class QuickSort {
	public int[] quickSort(int[] array) {
		if (array == null) {
			return array; 
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}
	public void quickSort(int[] array, int left, int right) {
		if (left >= right) return;
		int pivotIndex = partition(array, left, right);
		// the pivot is already at its position, thus when we do the recursive call 
		// on the two partitions, pivot should not be included in any of the call
		quickSort(array, left, pivotIndex - 1);
		quickSort(array, pivotIndex + 1, right);
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
			} else if (array[rightBound] >= pivot) {
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

	public static void main(String[] args) {
		QuickSort sort = new QuickSort();
		int[] array = new int[]{4, 3, 7, -3, 2, 10};
		System.out.println(Arrays.toString(sort.quickSort(array)));
	}
}
