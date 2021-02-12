class CheckFull {
	public boolean isFull(TreeNode root) {
		if (root == null) return false; // depends on clarification
		if (root.left == null && root.right == null) return true;
		if (root.left == null || root.right == null) return false;
		return isFull(root.left) && isFull(root.right); // pruning
	}
}
