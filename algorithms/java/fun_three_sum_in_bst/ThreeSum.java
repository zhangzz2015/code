class ThreeSum {
	// 1. serialize
	public List<List<Integer>> sum1(Node root, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Node[] headAndTail = treeToDoublyLinkedList(root);
		Node cur = headAndTail[0];
		while (cur.right != null && cur.right.right != null) {
			Node leftNode = cur.right;
			Node rightNode = headAndTail[1];
			while (leftNode.val < rightNode.val) {
				int tmp = cur.val + leftNode.val + rightNode.val;
				if (tmp == target) {
					res.add(Arrays.asList(cur.value, leftNode.val, rightNode.val);
					leftNode = leftNode.right;
					rightNode = rightNode.left;
				} else if (tmp < target) {
					leftNode = leftNode.right;
				} else {
					rightNode = rightNode.left;
				}
			}
			cur = cur.right;
		}
		return res;
	}
	private Node[] treeToDoublyLinkedList(Node root) {
		if (root == null) return null;
		Node prev = null;
		Node head = null;
		Deque<Node> stack = new ArrayDeque<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (prev == null) {
				head = root;
			} else {
				prev.right = root;
				root.left = prev;
			}
			prev = root;
			root = root.right;
		}
		return new Node[]{head, prev};
	}

	// 2. iterator
	public List<List<Integer>> sum2(TreeNode root, int target) {
		List<List<Integer>> res = new ArrayList<>();
		TreeIterator ascItr = new TreeIterator(root, true);
		TreeIterator desItr = new TreeIterator(root, false);
		while (ascItr.hasNext()) {
			TreeNode cur = ascItr.next();
			find2Sum(ascItr.copy(), desItr.copy(), target - cur.val, cur.val, res);
		}
		return res;
	}
	private void find2Sum(TreeIterator ascItr, TreeIterator desItr, int target, int first, List<List<Integer>> res) {
		TreeNode small = ascItr.hasNext() ? ascItr.next() : null;
		TreeNode large = desItr.hasNext() ? desItr.next() : null;
		while (small != null && large != null && small != large) {
			int tmp = small.val + large.val;
			if (tmp == target) {
				res.add(Arrays.asList(first, small.val, large.val));
			} else if (tmp < target) {
				small = ascItr.hasNext() ? ascItr.next() : null;
			} else {
				large = desItr.hasNext() ? desItr.next() : null;
			}
		}
	}
	static class TreeIterator {
		private Deque<TreeNode> stack;
		private boolean isForward;

		public TreeIterator(TreeNode root, boolean dir) {
			this.stack = new ArrayDeque<>();
			this.isForward = dir;
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public TreeNode next() {
			TreeNode cur = stack.peekFirst();
			while (cur != null) {
				stack.offerFirst(cur);
				cur = isForward ? cur.left : cur.right;
			}
			TreeNode res = stack.pollFirst();
			cur = isForward ? res.right : res.left;
			return res;
		}

		public TreeIterator copy() {
			TreeIterator clone = new TreeIterator(cur, isForward);
			clone.stack = new ArrayDeque<>(stack);
			return clone;
		}
	}
}
