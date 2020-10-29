class RainbowSort {
	public int[] rainbowSort(int[] array, int k) {
		if (array == null || array.length == 0) return array;
		int[] pointers = new int[k + 1];
		while (pointers[k] < array.length) {
			if (array[pointers[k] == k) {
				pointers[k]++;
			} else {
				int tmp = array[pointers[k]];
				for (int i = k - 1; i >= tmp; i--) {
					swap(array, pointers[i], pointers[i + 1]);
					pointers[i + 1]++;
				}
				pointers[tmp]++;
			}
		}
		return array;
	}
	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
