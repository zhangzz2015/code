class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		return hasPathSum(root, sum, 0);
	}
	private boolean hasPathSum(TreeNode root, int sum, int cur) {
		cur += root.val;
		if (root.left == null && root.right == null) {
			return sum == cur;
		}
		if (root.left != null && hasPathSum(root.left, sum, cur)) {
			return true;
		}
		if (root.right != null && hasPathSum(root.right, sum, cur)) {
			return true;
		}
		return false;
	}
}
