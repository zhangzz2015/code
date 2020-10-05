class Divide {
    // 1. go down the search path
    public TreeNode[] partition(TreeNode root, int pivot) {
        TreeNode[] roots = new TreeNode[2];
        TreeNode largestT1 = null;
        TreeNode smallestT2 = null;
        while (root != null) {
            if (root.val <= pivot) {
                if (roots[0] == null) {
                    roots[0] = root;
                } else {
                    largestT1.right = root;
                }
                largestT1 = root;
                root = root.right;
            } else {
                if (roots[1] == null) {
                    roots[0] = root;
                } else {
                    smallestT2.left = root;
                }
                smallestT2 = root;
                root = root.left;
            }
        }
        if (smallestT2 != null) {
            smallestT2.left = null;
        }
        if (largestT1 != null) {
            largestT1.right = null;
        }
        return roots;
    }

    // 2. pure recursion
    public TreeNode[] partition1(TreeNode root, int pivot) {
        TreeNode[] roots = new TreeNode[2];
        if (root == null) return roots;
        if (root <= pivot) {
            TreeNode[] tmp = partition1(root.right, pivot);
            roots[1] = tmp[1];
            root.right = tmp[0];
            roots[0] = root;
            return roots;
        } else {
            TreeNode[] tmp = partition1(root.left, pivot);
            roots[0] = tmp[0];
            root.left = tmp[1];
            roots[1] = root;
            return roots;
        }
    }
}
