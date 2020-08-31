public class CountUnivalueSubtree {
    
    private int count = 0;
    public int countUnivalSubtree(TreeNode root) {
        isUni(root);
        return count;
    }
    private boolean isUni(TreeNode root) {
        // base case
        if (root == null) return true;
        boolean left = isUni(root.left);
        boolean right = isUni(root.right);
        if ((root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val) && left && right) {
            count++;
            return true;
        }
        return false;
    }
}