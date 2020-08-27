import java.util.Deque;
import java.util.Queue;

public class TopView {
    class NodeWithColumn {
        TreeNode node;
        int column;
        public NodeWithColumn(TreeNode root, int column) {
            this.node = root;
            this.column = column;
        }
    }

    // generate == visit
    public List<Integer> topView1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<NodeWithColumn> queue = new ArrayDeque<>();
        queue.offer(new NodeWithColumn(root, 0));
        Deque<Integer> top = new ArrayDeque<>();
        int smallest = 0;
        int largest = 0;
        top.offer(root.val);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeWithColumn cur = queue.poll();
                if (cur.node.left != null) {
                    if (cur.column == smallest) {
                        top.offerFirst(cur.node.left.val);
                        smallest--;
                    }
                    queue.offer(new NodeWithColumn(cur.node.left, cur.column - 1));
                }
                if (cur.node.right != null) {
                    if (cur.column == largest) {
                        top.offerLast(cur.node.right.val);
                        largest++;
                    }
                    queue.offer(new NodeWithColumn(cur.node.right, cur.column + 1));
                }
            }
        }
        return new ArrayList<>(top);
    }

    // expand == visit
    public List<Integer> topView2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<Integer> top = new ArrayDeque<>();
        int smallest = 0;
        int largest = 0;
        Queue<NodeWithColumn> queue = new ArrayDequeM<>();
        queue.offer(new NodeWithColumn(root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NodeWithColumn cur = queue.poll();
                if (top.isEmpty()) {
                    top.offer(cur.node.val);
                } else if (cur.column < smallest) {
                    smallest = cur.column;
                    top.offerFirst(cur.node.val);
                } else if (cur.column > largest) {
                    largest = cur.column;
                    top.offerLast(cur.node.val);
                }
                if (cur.node.left != null) {
                    queue.offer(new NodeWithColumn(cur.node.left, cur.column - 1));
                }
                if (cur.node.right != null) {
                    queue.offer(new NodeWithColumn(cur.node.right, cur.column + 1));
                }
            }
        }
        return new ArrayList<>(top);
    }
}