public class LCA {
	
	static class TreeNode {
		int val;
		List<TreeNode> children;
	}

	public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		Set<TreeNode> set = new HashSet<>(nodes);
		return lca(root, set);
	}

	private TreeNode lca(TreeNode root, Set<TreeNode> set) {
		if (root == null || set.contains(root)) return root;
		TreeNode found = null;
		for (TreeNode child : root.children) {
			TreeNode node = lca(child, set);
			if (node == null) continue;
			if (found == null) found = node;
			else return root;
		}
		return found;
	}
}
