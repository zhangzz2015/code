class Permutation {
	public List<List<Integer>> permute(int[] nums) {
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
			for (int n : nums) {
				tmp.add(n);
			}
			res.add(tmp);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			swap(nums, index, i);
			dfs(nums, res, index + 1);
			swap(nums, index, i);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
