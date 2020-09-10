public class LCA {
	private int count = 0;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode res = lca(root, p, q);
		return count == 2 ? res : null;
	}
	private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return null;
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, q, p);
		if (root == p || root == q) {
			count++;
			return root;
		}
		if (left != null && right != null) {
			return root;
		}
		return left == null ? right : left;
	}
}
