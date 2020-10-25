class JumpGame {
	// dp
	public boolean canJump1(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		boolean[] m = new boolean[nums.length];
		dp[0] = true;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (m[j] == true && j + nums[j] >= i) {
					m[i] = true;
				}
			}
		}
		return m[m.length - 1];
	}

	// greedy
	public boolean canJummp2(int[] nums) {
		if (nums == null || nums.length == 0) return false;
		int max = 0;
		int i = 0;
		for (; i < Math.min(max, nums.length - 1); i++) {
			max = Math.max(max, nums[i] + i);
		}
		return i == nums.length;
	}
}
