public class PopulateNext {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

    public Node connect(Node root) {
        if (root == null) return root;
        Node nextLevelHead = null;
        Node curNode = root;
        Node prevNode = null;
        while (curNode != null) {
            if (prevNode == null) {
                prevNode = curNode.left;
            } else {
                prevNode.next = curNode.left;
                prevNode = prevNode.next;
            }
            if (nextLevelHead == null) {
                nextLevelHead = curNode.left;
            }
            if (prevNode == null) {
                prevNode = curNode.right;
            } else {
                prevNode.next = curNode.right;
                prevNode = prevNode.next;
            }
            if (nextLevelHead == null) {
                nextLevelHead = curNode.right;
            }
            curNode = curNode.next;
            if (curNode == null) {
                curNode = nextLevelHead;
                nextLevelHead = null;
                prevNode = null;
            }
        }
        return root;
    }
}