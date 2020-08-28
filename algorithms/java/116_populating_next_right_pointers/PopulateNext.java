public class PopulateNext {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

    // 1 basic bfs 
    public void populate1(Node root) {
        if (root == null) return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (prev != null) prev.next = cur;
                prev = cur;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
    } 

    // 2 space optimize
    public void populate2(Node root) {
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
    }

    // DFS
    public void populate3(Node root) {
        List<Node> tails = new ArrayList<>();
        dfs(tails, root, 0);
    }
    private void dfs(List<Node> tials, Node root, int level) {
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