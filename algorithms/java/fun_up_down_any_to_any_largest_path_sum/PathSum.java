public class PathSum {
    
    // 1. backtracking
    private int globalLargest = Integer.MIN_VALUE;
    public int maxPathSum1(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        backtracking(root, 0);
        return globalLargest;
    }
    private void backtracking(TreeNode cur, int prevLargest) {
        // 1. base case leaf node. no need to wright anything here
        // 2. calculate the largest path sum ending at cur node
        int largest = root.val + (prevLargest < 0 ? 0 : prevLargest);
        globalLargest = Math.max(globalLargest, largest);
        // 3. backtracking
        if (root.left != null) backtracking(cur.left, largest);
        if (root.right != null) backtracking(cur.right, largest);
    }

    // 2. pure recursion
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {
        // base case
        if (root == null) return 0;
        // recursion
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        int largest = root.val + Math.max(left, Math.max(right, 0));
        globalMax = Math.max(globalMax, largest);
        return largest;
    }
}