public class RemoveZero {
    public TreeNode deleteAllZero(TreeNode root) {
        // base case
        if (root == null) return null;
        // recursion call
        root.left = deleteAllZero(root.left);
        root.right = deleteAllZero(root.right);
        // induction rule
        if (root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }
}