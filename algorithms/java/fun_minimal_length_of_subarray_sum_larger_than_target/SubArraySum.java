class SubArraySum {
	public int find1(int[] array, int target) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		int curSum = 0;
		while (j < array.length) {
			curSum += array[j];
			while (i <= j && curSum >= target) {
				min = Math.min(min, j - i + 1);
				curSum -= array[i];
				i++;
			}
			j++;
		}
		return min;
	}

	// do not use two while loop
	public int find2(int[] array, int target) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		int curSum = array[0];
		while (j < array.length) {
			if (curSum >= target) {
				min = Math.min(min, j - i + 1);
				curSum -= array[i];
				i++;
			} else {
				j++;
				if (j == array.length) break;
				curSum += array[j];
			}
		}
		return min;
	}
}
