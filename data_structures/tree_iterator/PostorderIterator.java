class PostorderIterator {
	private Deque<TreeNode> stack;

	public PostorderIterator(TreeNode root) {
		this.stack = new ArrayDeque<>();
		findNextLeaf(root);
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException("End of the iterator");
		}
		TreeNode res = stack.pollFirst();
		if (!stack.isEmpty()) {
			TreeNode top = stack.peekFirst();
			if (res == top.left) {
				findNextLeaf(top.right);
			}
		}
		return res.val;
	}

	private void findNextLeaf(TreeNode cur) {
		while (cur != null) {
			stack.offerFirst(cur);
			if (cur.left != null) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
	}
}
