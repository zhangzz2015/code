class HouseRobber {
	
	// 1. dp
	static class Res {
		int rob;
		int unRob;
		Res(int rob, int unRob) {
			this.rob = rob;
			this.unRob = unRob;
		}
	}
	public int rob1(TreeNode root) {
		if (root == null) return 0;
		Res res = robTree(root);
		return Math.max(res.rob, res.unRob);
	}
	private Res robTree(TreeNode root) {
		if (root == null) {
			return new Res(0, 0);
		}
		Res left = robTree(root.left);
		Res right = robTree(root.right);
		int rob = left.unRob + right.unRob + root.val;
		int unRob = Math.max(left.rob, left.unRob) + Math.max(right.rob, right.unRob);
		return new Res(rob, unRob);
	}

	// 2. backtracking + memoization
	Map<TreeNode, Integer> map = new HashMap<>();
	public int rob2(TreeNode root) {
		if (root == null) return 0;

		// memo
		if (map.get(root) != null) return map.get(root);

		int rob = root.val;
		if (root.left != null) {
			rob += rob2(root.left.left) + rob2(root.left.right);
		}
		if (root.right != null) {
			rob += rob2(root.right.left) + rob2(root.right.right);
		}
		int notRob = rob2(root.left) + rob2(root.right);
		int val = Math.max(rob, notRob);

		// memo
		map.put(root, val);

		return val;
	}
}
