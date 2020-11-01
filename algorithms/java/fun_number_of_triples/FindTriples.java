class FindTriples {
	// cleaner way to write
	public int findTriples(int[] array, int target) {
		int res = 0;
		for (int k = array.length - 1; i >= 2; i--) {
			int i = 0;
			int j = k - 1;
			while (j >= 1) {
				if (i >= j) {
					res += j--;
				} else if (array[i] + array[j] + array[k] < target) {
					i++;
				} else {
					res += i;
					j--;
				}
			}
		}
		return res;
	}

	public int find(int[] array, int target) {
		if (array == null || array.length < 3) return 0;
		int res = 0;
		int k = array.length - 1;
		while (k >= 2) {
			int tmp = target - array[k];
			int j = k - 1;
			int i = 0;
			while (j >= 1) {
				while (i < j && array[i] + array[j] < tmp) {
					i++;
				}
				res += Math.min(i, j);
				j--;
			}
			k--;
		}
		return res;
	}
}
