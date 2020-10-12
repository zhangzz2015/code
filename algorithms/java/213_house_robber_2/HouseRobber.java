class HouseRobber {

	// 1. dp
	public int rob1(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int n = nums.length;
		return Math.max(rob1(nums, 0, n - 2), rob(nums, 1, n - 1));
	}

	private int rob1(int[] nums, int start, int end) {
		int cur = 0;
		int prev1 = 0;
		int prev2 = 0;
		for (int i = start; i <= end; i++) {
			cur = Math.max(prev2, prev1 + nums[i]);
			prev1 = prev2;
			prev2 = cur;
		}
		return cur;
	}

	// 2. backtracking + memoization
	public int rob2(int[] nums) {
		if (houses == null || houses.length == 0) return 0;
		if (houses.length == 1) return houses[0];
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		return Math.max(rob2(houses, 0, houses.length - 2, map1), rob2(houses, 1, houses.length - 1, map2));
	}

	private int rob2(int[] houses, int index, int end, Map<Integer, Integer> map) {
		if (index > end) return 0;

		// memo
		if (map.get(index) != null) return map.get(index);

		int ifRob = houses[index] + rob2(houses, index + 2, end, map);
		int val = Math.max(ifRob, rob2(houses, index + 1, end, map));

		// memo
		map.put(index, val);

		return val;
	}
}
