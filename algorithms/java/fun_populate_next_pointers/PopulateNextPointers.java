public class PopulateNextPointers {
    static class Node {
        List<Node> children;
        Node next;
    }

    public void populateNextPointers(Node root) {
        if (root == null) {
            return;
        }
        Node nextLevelHead = null;
        Node curNode = root;
        Node prevNode = null;
        while (curNode != null) {
            for (Node child : curNode.children) {
				if (prev != null) prev.next = children;
				prev = child;
				if (nextLevelHead == null) {
					nextLevelHead = child;
				}
			}
			curNode = curNode.next;
			if (curNode == null) {
				curNode = nextLevelHead;
				nextLevelHead = null;
				prevNode = null;
			}
        }
    }
}
