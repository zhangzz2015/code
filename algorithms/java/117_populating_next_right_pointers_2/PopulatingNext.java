public class PopulatingNext {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

	// BFS
    public Node connect(Node root) {
        if (root == null) return root;
        Node head = root;
        while (head != null) {
            Node prev = null;
            Node nextHead = null;
            while (head != null) {
                if (head.left != null) {
                    if (prev != null) {
                        prev.next = head.left;
                    }
                    prev = head.left;
                    if (nextHead == null) {
                        nextHead = head.left;
                    }
                }
                if (head.right != null) {
                    if (prev != null) {
                        prev.next = head.right;
                    }
                    prev = head.right;
                    if (nextHead == null) {
                        nextHead = head.right;
                    }
                }
                head = head.next;
            }
            head = nextHead;
        }
        return root;
    }
	
	// DFS
	public Node connect1(Node root) {
		List<Node> tails = new ArrayList<>();
		dfs(tails, root, 0);
		return root;
	}
	private void dfs(List<Node> tails, Node root, int level) {
		if (root == null) return;
		if (tails.size() == level) {
			tails.add(root);
		} else {
			tails.get(level).next = root;
			tails.set(level, root);
		}
		dfs(tails, root.left, level + 1);
		dfs(tails, root.right, level + 1);
	}
}
