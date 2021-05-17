class InsertionSort {
	public void insertionSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}
		int len = array.length;
		for (int i = 1; i < n; i++) {
			int cur = array[i];
			int j = i - 1;
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
}
