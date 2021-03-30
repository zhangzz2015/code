class Convert {
	// 1. traverse
	Node head;
	Node prev;
	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return null;
		}
		inOrder(root);
		head.left = prev;
		prev.right = head;
		return head;
	}
	private void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		if (head == null) head = root;
		if (prev != null) prev.right = root;
		root.left = prev;
		prev = root;
		inOrder(root.right);
	}

	// 2. recursion
	public Node treeToDoublyList(Node root) {
		if (root == null) return null;
		return connect(root);
	}
	private Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Node left = connect(root.left);
		Node right = connect(root.right);
		root.left = root;
		root.right = root;
		return link(link(left, root), right);
	}
	private Node link(Node leftHeda, Node rightHead) {
		if (left == null) {
			return rightHead;
		}
		if (right == null) {
			return leftHead;
		}
		Node leftTail = leftHead.left;
		Node rightTail = rightHead.left;
		
		leftHead.left = rightTail;
		rightTail.right = leftHead;

		rightHead.left = leftTail;
		leftTail.right = rightHead;
		
		return left;
	}
}
