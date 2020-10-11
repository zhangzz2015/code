class TwoSum {
	public int find(int[] a1, int[] a2, int target) {
		if (a1 == null || a2 == null || a1.length == 0 || a2.length == 0) {
			return 0;
		}
		int i = 0;
		int j = a2.length - 1;
		int count = 0;
		while (i < a1.length && j >= 0) {
			if (a1[i] + a2[j] > target) {
				j--;
			} else {
				i++;
				count += j + 1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		TwoSum solve = new TwoSum();
		int[] a1 = {1, 3, 6};
		int[] a2 = {2, 4, 5};
		System.out.println(solve.find(a1, a2, 7));
	}
}
