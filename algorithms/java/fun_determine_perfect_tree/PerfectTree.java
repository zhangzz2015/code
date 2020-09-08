class PerfectTree {
	// 1. BFS
	public boolean isPerfect(TreeNode root) {
		if (root == null) return true;
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		int prevSize = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (prevSize != 0 && size != prevSize * 2) {
				return false;
			}
			if (root.left != null) queue.offer(root.left);
			if (root.right != null) queue.offer(root.right);
			prevSize = size;
		}
		return true;
	}

	// 2. pure recursion
	public boolean isPerfect1(TreeNode root) {
		return helper(root) >= 0;	
	}
	private int helper(TreeNode root) {
		if (root == null) return 0;
		int left = helper(root.left);
		if (left < 0) return -1;
		int right = helper(root.right);
		if (right < 0) return -1;
		if (left == right) return left + 1;
		return -1;	
	}
}
