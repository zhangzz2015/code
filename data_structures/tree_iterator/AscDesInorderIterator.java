class AscDesInorderIterator {
	private Deque<TreeNode> stack;
	private boolean isForward;

	public TreeIterator(TreeNode root, boolean dir) {
		TreeNode cur = root;
		this.stack = new ArrayDeque<>();
		isForward = dir;
		while (cur != null) {
			stack.offerFirst(cur);
			cur = isForward ? cur.left : cur.right;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();;
	}

	public TreeNode next() {
		if (!hasNext()) {
			throw new NoSuchElementException("End of the iterator!");
		}
		TreeNode cur = stack.pollFirst();
		TreeNode tmp = isForward ? cur.right : cur.left;
		while (tmp != null) {
			stack.offerFirst(tmp);
			tmp = isForward ? cur.left : cur.right;
		}
		return cur.val;
	}
}
