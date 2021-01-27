class Permutation {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		dfs(nums, res, 0);
		return res;
	}
	private void dfs(int[] nums, List<List<Integer>> res, int index) {
		if (index == nums.length) {
			List<Integer> tmp = new ArrayList<>();
			for (int i : nums) {
				tmp.add(i);
			}
			res.add(tmp);
			return;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = index; i < nums.length; i++) {
			if (set.add(nums[i]) {
				swap(nums, i, index);
				dfs(nums, res, index + 1);
				swap(nums, i, index);
			}
		}
	}
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
