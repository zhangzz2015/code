class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key == root.val) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            } else {
                TreeNode newRoot = deleteSmallest(root.right);
                newRoot.left = root.left;
                newRoot.right = root.right;
                return newRoot;
            }
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode deleteSmallest(TreeNode root) {
        while (roo.left.left != null) {
            root = root.left;
        }
        TreeNode smallest = root.left;
        root.left = root.left.right;
        return smallest;
    }
}
