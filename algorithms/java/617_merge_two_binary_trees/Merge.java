class Merge {
	public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		t1.val += t2.val;
		return t1;
	}

	public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(t1);
        queue.offer(t2);
        while (!queue.isEmpty()) {
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();
            a.val += b.val;
            if (a.left == null) {
                a.left = b.left;
            } else {
                if (b.left != null) {
                    queue.offer(a.left);
                    queue.offer(b.left);
                }
            }
            if (a.right == null) {
                a.right = b.right;
            } else {
                if (b.right != null) {
                    queue.offer(a.right);
                    queue.offer(b.right);
                }
            }
        }
        return t1;
    }
}
