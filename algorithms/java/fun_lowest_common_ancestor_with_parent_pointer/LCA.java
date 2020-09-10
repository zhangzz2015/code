public class LCA {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		int l1 = length(p);
		int l2 = length(q);
		if (l1 <= l2) {
			return merge(p, q, l2 - l1);
		} else {
			return merge(q, p, l1 - l2);
		}
	}
	private int length(TreeNode node) {
		int length = 0;
		while (node != null) {
			length++;
			node = node.parent;
		}
		return length;
	}
	private TreeNode merge(TreeNode higher, TreeNode lower, int diff) {
		while (diff > 0) {
			lower = lower.parent;
			diff--;
		}
		while (lower != higher) {
			higher = higher.parent;
			lower = lower.parent;
		}
		return higher;
	}
}
