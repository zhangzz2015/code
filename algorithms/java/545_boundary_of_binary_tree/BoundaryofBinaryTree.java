public class BoundaryofBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        dfs(root.left, true, false, res);
        dfs(root.right, false, true, res);
        return res;
    }

    private void dfs(TreeNode root, boolean leftMost, boolean rightMost, List<Integer> res) {
        if (root == null) return;
        if (leftMost || root.left == null && root.right == null) {
            res.add(root.val);
        }
        dfs(root.left, leftMost, rightMost && root.right == null, res);
        dfs(root.right, leftMost && root.left == null, rightMost, res);
        if (rightMost && (root.left != null || root.right  != null)) {
            res.add(root.val);
        }
    }
}