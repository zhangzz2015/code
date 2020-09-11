public class SubtreeWithAllDeepest {

	static class ReturnType {
		TreeNode root;
		int deepestLevel;
		ReturnType(TreeNode root, int deepestLevel) {
			this.root = root;
			this.deepestLevel = deepestLevel;
		}
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null) return null;
		return lca(root, 0).root;
	}

	private ReturnType lca(TreeNode root, int deepestLevel) {
		if (root.left == null && root.right == null) {
			return new ReturnType(root, deepestLevel);
		}
		if (root.left == null) return lca(root.right, deepestLevel + 1);
		if (root.right == null) return lca(root.left, deepestLevel + 1);
		ReturnType left = lca(root.left, deepestLevel + 1);
		ReturnType right = lca(root.right, deepestLevel + 1);
		if (left.deepestLevel == right.deepestLevel) {
			return new ReturnType(root, left.deepestLevel);
		}
		return left.deepestLevel > right.deepestLevel ? left : right;
	}
}
