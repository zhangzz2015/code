public class CountCompleteTree {
    public int countCompleteTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1;
        TreeNode leftNode = root.left;
        while (leftNode != null) {
            left++;
            leftNode = leftNode.left;
        }
        int right = 1;
        TreeNode rightNode = root.right;
        while (rightNode != null) {
            right++;
            rightNode = rightNode.right;
        }
        if (left == right) {
            return Math.pow(2, x) - 1;
        }
        return countCompleteTree(root.left) + countCompleteTree(root.right) + 1;
    }
}