class 3SumClosest {
	public int closest(int[] nums, int target) {
		if (nums == null || nums.length < 3) return Integer.MAX_VALUE;
		Arrays.sort(nums);
		int res = nums[0] + nums[1] + nums[2];
		for (int k = 3; k < nums.length; k++) {
			int i = 0;
			int j = k - 1;
			while (i < j) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target) {
					return sum;
				}
				if (Math.abs(sum - target) < Math.abs(res - target)) {
					res = sum;
				}
				if (sum < target) {
					i++;
				} else {
					j--;
				}
			}
		}
		return res;
	}
}
