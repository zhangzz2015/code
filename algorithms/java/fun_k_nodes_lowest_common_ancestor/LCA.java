public class LCA {
	public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		Set<TreeNode> set = new HashSet<>(nodes);
		return lca(root, set);
	}

	private TreeNode lca(TreeNode root, Set<TreeNode> set) {
		if (root == null) return null;
		if (set.contains(root)) return root;
		TreeNode left = lca(root.left, set);
		TreeNode right = lca(root.right, set);
		if (left != null && right != null) return root;
		return left == null ? right : left;
	}
}
