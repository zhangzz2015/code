public class PopulatingNext {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

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
}