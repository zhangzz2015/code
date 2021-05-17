class BubbleSort {
	public void bubbleSort(int[] array) {
		int len = array.length;
		if (len <=  1) {
			return;
		}
		boolean flag = false; // when there is no swap we can terminate early
		for (int i = 0; i < len; i++) {
			flag = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
	}
}
