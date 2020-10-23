class MissingNumber {
	// 1. use HashSet
	public int missingNumber1(int[] nums) {
		if (nums == null || nums.length == 0) return -1;
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		for (int i = 0; i <= nums.length; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return nums.length;
	}

	// 2. sum
	public int missingNumnber2(int[] nums) {
		int n = nums.length;
		long targetSum = (long) n * (n - 1) / 2;
		for (int i = 0; i < n; i++) {
			targetSum -= nums[i];
		}
		return (int)targetSum;
	}

	// 3. bit operation
	public int missingNumber(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res ^= i;
			res ^= nums[i];
		}
		return res;
	}
}
