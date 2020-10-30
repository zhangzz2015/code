class FindNearestRightNode {
	// bfs
	// 1. using null node
	public TreeNode find1(TreeNode root, TreeNode u) {
		if (root == null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur != null) {
				if (cur == u) {
					return queue.poll();
				}
				if (cur.left != null) queue.offer(cur.left);
				if (cur.right != null) queue.offer(cur.right);
			} else {
				if (!queue.isEmpty()) queue.offer(null);
			}
		}
		return null;
	}

	// 2. check with level size
	public TreeNode find2(TreeNode root, TreeNode u) {
		if (root == null) return null;
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur == u) {
					return i != size - 1 ? queue.poll() : null;
				}
				if (cur.left != null) queue.offer(cur.left);
				if (cur.right != null) queue.offer(cur.right);
			}
		}
		return null;
	}

	// dfs
	int level = -1;
	TreeNode res = null;
	public TreeNode find3(TreeNode root, TreeNode u) {
		if (root == null) return null;
		dfs(root, u, 0);
		return res;
	}
	private void dfs(TreeNode root, TreeNode u, int curLevel) {
		if (root == null || res != null) return;
		if (root == u) {
			level = curLevel;
			return;
		}
		if (level == curLevel) {
			res = root;
			return;
		}
		dfs(root.left, u, curLevel + 1);
		dfs(root.right, u, curLevel + 1);
	}
}
