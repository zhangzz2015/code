public class Convert {
    
    // 2. pure recursion
    public TreeNode flatten(TreeNode root) {
        if (root == null) return null;
        TreeNode left = flatten(root.left);
        TreeNode right = flatten(root.right);
        // convert root to a one element doubly linked list
        root.left = root;
        root.right = root;
        left = connect(left, root);
        left = connect(left, right);
        return left;
    }

    // return the head after connect h1 and h2
    private TreeNode connect(TreeNode h1, TreeNode h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        TreeNode t1 = h1.prev;
        TreeNode t2 = h2.prev;
        // 1 tail to 2 head
        t1.right = h2;
        h2.left = t1;
        // 2 tail to 1 head
        t2.right = h1;
        h1.left = t2;
        return h1;
    }
}
