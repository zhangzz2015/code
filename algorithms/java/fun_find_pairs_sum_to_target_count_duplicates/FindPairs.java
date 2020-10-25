class FindPairs {
	public int findPairs(int[] array, int target) {
		if (array == null) return 0;
		int count = 0;
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			int sum = array[i] + array[j];
			if (sum == target) {
				if (array[i] == array[j]) {
					count += (j - i + 1) * (j - i) / 2;
					break;
				}
				int leftCount = 1;
				while (array[i] == array[i + 1]) {
					i++;
					leftCount++;
				}
				i++;
				int rightCount = 1;
				while (array[j - 1] == array[j]) {
					j--;
					rightCount++;
				}
				j--;
				count += leftCount * rightCount;
			} else if (sum < target) i++;
			else j--;
		}
		return count;
	}

	public static void main(String[] args) {
		FindPairs solve = new FindPairs();
		int[] input = new int[]{1, 1, 2, 2, 2, 3, 3}; // target = 4, return 7
		System.out.println(solve.findPairs(input, 4));
	}
}
