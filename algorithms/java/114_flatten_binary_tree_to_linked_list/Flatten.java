class Flatten {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
        root.left = null;
    }
}
