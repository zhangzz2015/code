class Successor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode prev = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val) {
                prev = cur;
                cur = cur.left;
            } else if (cur.val < p.val) {
                cur = cur.right;
            } else {
                if (cur.right != null) return findSmallest(cur.right);
                return prev;
            }
        }
        return null;
    }
    
    private TreeNode findSmallest(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }
}
