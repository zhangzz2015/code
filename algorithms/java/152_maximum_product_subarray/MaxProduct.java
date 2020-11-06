class MaxProduct {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int prevMax = nums[0], prevMin = nums[0], curMax = nums[0], curMin = nums[0];
		int maxProduct = nums[0];
		for (int i = 1; i < nums.length; i++) {
			curMax = Math.max(nums[i], Math.max(prevMax * nums[i], prevMin * nums[i]));
			curMin = Math.min(nums[i], Math.min(prevMax * nums[i], prevMin * nums[i]));
			maxProduct = Math.max(maxProduct, curMax);
			prevMax = curMax;
			prevMin = curMin;
		}
		return maxProduct;
	}
}
