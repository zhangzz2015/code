class Subsets {
	// 1. add or not add
	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		List<Integer> partial = new ArrayList<>();
		dfs1(nums, res, partial, 0);
		return res;
	}
	private void dfs1(int[] nums, List<List<Integer>> res, List<Integer> partial, int index) {
		if (index == nums.length) {
			res.add(new ArrayList<>(partial));
			return;
		}
		partial.add(nums[index]);
		dfs1(nums, res, partial, index + 1);
		partial.remove(partial.size() - 1);
		while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
			index++;
		}
		dfs1(nums, res, partial, index + 1);
	}

	// 2. combination
	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Arrays.sort(nums);
		List<Integer> partial = new ArrayList<>();
		dfs2(nums, res, partial, 0);
		return res;
	}
	private void dfs2(int[] nums, List<List<Integer>> res, List<Integer> partial, int index) {
		res.add(new ArrayList<>(partial));
		for (int i = index; i < nums.length; i++) {
			if (i == index || nums[i] != nums[i - 1]) {
				partial.add(nums[i]);
				dfs2(nums, res, partial, i + 1);
				partial.remove(partial.size() - 1);
			}
		}
	}
}
