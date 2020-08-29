import java.util.Deque;

public class ZigzagLevelOrder {

    // 1. BFS
    public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (level % 2 == 0) {
                    TreeNode cur = deque.pollFirst();
                    curLevel.add(cur.val);
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                } else {
                    TreeNode cur = deque.pollLast();
                    curLevel.add(cur.val);
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                }
            }
            level++;
            res.add(curLevel);
        }
        return res;
    }


    // 2. DFS
    public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, 0);
        return res;
    }
    private void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (level >= res.size()) {
            List<Integer> newLevel = new LinkedList<>();
            newLevel.add(root.val);
            res.add(newLevel);
        } else {
            if (level % 2 == 0) {
                res.get(level).add(root.val);
            } else {
                res.get(level).add(0, root.val);
            }
        }
        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }
}