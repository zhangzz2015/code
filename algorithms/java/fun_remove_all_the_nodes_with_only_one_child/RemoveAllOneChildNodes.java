public class RemoveAllOneChildNodes {
	public TreeNode removeOneChildNodes(TreeNode root) {
		if (root == null) return null;
		TreeNode left = removeOneChildNodes(root.left);
		TreeNode right = removeOneChildNodes(root.right);
		if (left == null && right == null) {
			return root;
		} else if (left != null && right != null) {
			root.left = left;
			root.right = right;
			return root;
		}
		return left == null ? right : left;
	}
}
