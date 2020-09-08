public class QuickSelect {
	
	// partition part that both implementation need
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

	// 1. recursion
	public int quickSelectRecursive(int[] array, int k) {
		if (array == null || array.length == 0) return Integer.MIN_VALUE;
		if (k < 1 || k > array.length) return Integer.MIN_VALUE; // return special value to check validation
		return kth(array, k, 0, array.length - 1);
	}
	public int kth(int[] array, int k, int left, int right) {
		// if we already guarantee kth smallest must exist no need of:
		// if (left > right) return ???;
		int pivotIndex = partition(array, left, right);
		if (k - 1 == pivotIndex) return array[pivotIndex];
		else if (k - 1 < pivotIndex) return kth(array, k, left, pivotIndex - 1);
		else return kth(array, k, pivotIndex + 1, right);
	}

	// 2. iterative
	public int quickSelect(int[] array, int k) {
		if (array == null || array.length == 0) return Integer.MIN_VALUE;
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int pivotIndex = partition(array, left, right);
			if (pivotIndex == k - 1) {
				return array[pivotIndex];
			}
			if (pivotIndex < k - 1) {
				left = pivotIndex + 1;
			} else {
				right = pivotIndex - 1;
			}
		}
		return Integer.MIN_VALUE;
	}
	

	public static void main(String[] args) {
		QuickSelect solution = new QuickSelect();
		int[] array = new int[]{4, 6, 3, 2, 1, 7, 5, 8};
		System.out.print(solution.quickSelect(array, 1));
		System.out.print(solution.quickSelect(array, 2));
		System.out.print(solution.quickSelect(array, 3));
		System.out.print(solution.quickSelect(array, 4));
		System.out.print(solution.quickSelect(array, 5));
		System.out.print(solution.quickSelect(array, 6));
		System.out.print(solution.quickSelect(array, 7));
		System.out.print(solution.quickSelect(array, 8));
		System.out.println("");
		System.out.print(solution.quickSelectRecursive(array, 1));
		System.out.print(solution.quickSelectRecursive(array, 2));
		System.out.print(solution.quickSelectRecursive(array, 3));
		System.out.print(solution.quickSelectRecursive(array, 4));
		System.out.print(solution.quickSelectRecursive(array, 5));
		System.out.print(solution.quickSelectRecursive(array, 6));
		System.out.print(solution.quickSelectRecursive(array, 7));
		System.out.print(solution.quickSelectRecursive(array, 8));
	}
}
