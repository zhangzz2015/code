public class LCA {
	
	static class TreeNode {
		int val;
		List<TreeNode> children;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;
		TreeNode found = null;
		for (TreeNode child : root.children) {
			TreeNode node = lowestCommonAncestor(child, p, q);
			if (node == null) continue;
			if (found == null) found = node;
			else return root;
		}
		return found;
	}
}
