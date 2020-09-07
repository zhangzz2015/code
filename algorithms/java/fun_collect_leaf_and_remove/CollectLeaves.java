public class CollectLeaves {
	public List<List<Integer>> collect(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(root, res);
		return res;
	}
	private int helper(TreeNode root, List<List<Integer>> res) {
		if (root == null) return 0;
		int left = helper(root.left, res);
		int right = helper(root.right, res);
		int height = Math.max(left, right) + 1;
		if (res.size() < height) {
			res.add(new ArrayList<>());
		}
		res.get(height - 1).add(root.val);
		return height;
	}
}
