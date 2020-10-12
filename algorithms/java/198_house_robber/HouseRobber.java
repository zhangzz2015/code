class HouseRobber {
	
	// 1. dp
	public int rob1(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int tmp1 = nums[0];
		if (nums.length == 1) return tmp1;
		int tmp2 = Math.max(nums[0], nums[1]);
		int res = tmp2;
		for (int i = 2; i < nums.length; i++) {
			res = Math.max(tmp1 + nums[i], tmp2);
			tmp1 = tmp2;
			tmp2 = res;
		}
		return res;
	}

	// 2. backtracking + memoization
	public int rob2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		Map<Integer, Integer> map = new HashMap<>();
		return rob(nums, 0, map);
	}

	private int rob2(int[] houses, int index, Map<Integer, Integer> map) {
		if (index >= houses.length) return 0;
		//memo
		if (map.get(index) != null) return map.get(index);
		
		int ifRob = houses[index] + rob2(houses, index + 2, map);
		int val = Math.max(ifRob, rob2(houses, index + 1, map));

		//memo
		map.put(index, val);
		
		return val;
	}
}
