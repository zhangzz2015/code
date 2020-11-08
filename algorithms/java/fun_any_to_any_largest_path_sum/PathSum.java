public class PathSum {    
    int globalMax = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		largest(root);
		return globalMax;
	}
    private int largest(TreeNode root) {
        // base case
        if (root == null) return 0;
        // recursion
        int left = Math.max(0, largest(root.left));
        int right = Math.max(0, largest(root.right));
        // update global max
        int largest = left + right + root.val;
        globalMax = Math.max(largest, globalMax);
        return Math.max(left, right) + root.val;
    }
}
