public class VisibleNodes {
    
    public List<Integer> allVisible(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, null);
        return res;
    }

    private void dfs(TreeNode cur, List<Integer> res, TreeNode max) {
        // base case
        if (cur == null) return;
        if (max == null || cur.val > max.val) {
            res.add(cur.val);
            max = cur;
        }
        dfs(cur.left, res, max);
        dfs(cur.right, res, max);
        // no need to recover for backtracking
    }
}