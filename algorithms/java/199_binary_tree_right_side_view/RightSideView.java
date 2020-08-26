import java.util.Queue;

import javax.swing.tree.TreeNode;

public class RightSideView {
    
    // 1. DFS
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightView(res, root, 0);
        return res;
    }

    private void rightView(List<Integer> res, TreeNode root, int level) {
        if (root == null) return;
        if (res.size() == level) res.add(root.val);
        rightView(res, root.right, level + 1);
        rightView(res, root.left, level + 1);
    }

    // 2. BFS
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.right != null) queue.offer(cur.right);
                if (cur.left != null) queue.offer(cur.left);
            }
        }
        return res;
    }
}