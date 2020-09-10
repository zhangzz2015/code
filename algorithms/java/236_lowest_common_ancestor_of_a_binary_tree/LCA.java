public class LCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		// case 1, 2, 3 optimization
		if (root == p || root == q) return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		// case 4
		if (left != null && right != null) return root;
		// case 2, 3
		if (left != null) return left;
		if (right != null) return right;
		return null;
	}

	// refactor
	public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		if (left != null && right != null) return root;
		return left == null ? right : left;
	}
}
