public class RetainNodesInRange {
    
    public TreeNode deleteNodeInRange(TreeNode root, int min, int max) {
        if (root == null) return null;
        root.left = deleteNoInRange(root.left, min, max);
        root.right = deleteNodeInRange(root.right, min, max);
        // case 1: root not in range
        if (root.val >= min && root.val <= max) {
            return root;
        }
        // case 2: root out of range
        return root.val < min ? root.right : root.left;
    }

    // optimize 1
    public TreeNode deleteNodeInRange1(TreeNode root, int min, int max) {
        if (root == null) return null;
        if (root.val < min) {
            return deleteNodeInRange1(root.right, min, max);
        }
        if (root.val > max) {
            return deleteNodeInRange1(root.left, min, max);
        }
        root.left = deleteNodeInRange1(root.left, min, max);
        root.right = deleteNodeInRange1(root.right, min, max);
        return root;
    }

    // optimize 2
    public TreeNode deleteNodeInRange2(TreeNode root, int min, int max, int left, int right) {
        if (root == null) return null;
        if (root.val < min) {
            return deleteNodeInRange2(root.right, min, max, root.val + 1, right);
        }
        if (root.val > max) {
            return deleteNodeInRange2(root.left, min, max, left, root.val - 1);
        }
        if (left >= min && right <= max) return root;
        root.left = deleteNodeInRange2(root.left, min, max, left, root.val - 1);
        root.right = deleteNodeInRange2(root.right, min, max, root.val + 1, right);
        return root;
    }
}