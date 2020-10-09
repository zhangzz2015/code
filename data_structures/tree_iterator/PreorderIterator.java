class PreorderIterator {
	private Deque<TreeNode> stack;

	public PreorderIterator(TreeNode root) {
		this.stack = new ArrayDeque<>();
		stack.offerFirst(root);
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public TreeNode next() {
		if (!hasNext()) {
			throw new NoSuchElementException("End of the iterator!");
		}
		TreeNode cur = stack.pollFirst();
		if (cur.right != null) {
			stack.offerFirst(cur.right);
		}
		if (cur.left != null) {
			stack.offerFirst(cur.left);
		}
		return cur;
	}
}
