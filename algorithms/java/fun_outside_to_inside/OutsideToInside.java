import java.util.ArrayDeque;
import java.util.Queue;

public class OutsideToInside {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(List.of(root.val));
        Queue<TreeNode> left = new ArrayDeque<>();
        Queue<TreeNode> right = new ArrayDeque<>();
        if (root.left != null) {
            left.offer(root.left);
        }
        if (root.right != null) {
            right.offer(root.right);
        }
        while (!left.isEmpty() || !right.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            traverseTree(left, curLevel, true);
            traverseTree(right, curLevel, false);
            res.add(curLevel);
        }
        return res;
    }

    private void traverseTree(Queue<TreeNode> queue, List<Integer> curLevel, boolean isLeft) {
        int size = queue.size();
        while (size-- !=  0) {
            TreeNode cur = queue.poll();
            curLevel.add(cur.value);
            if (isLeft) {
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            } else {
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }
        }
    }
}