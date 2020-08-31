public class LongestIncreasingPath {
    
    // 1. backtracking
    private int max = 1;
    public int longestIncreasingPath(TreeNode root) {
        longest(root, Integer.MAX_VALUE, 0);
        return max;
    }
    private int longest(TreeNode cur, int prevValue, int prevLongest) {
        if (cur == null) return 0;
        // add the cur node to the current path
        int curLongest = (cur.val > prevValue) ? prevLongest + 1 : 1;
        max = Math.max(max, curLongest);
        int left = longest(cur.left, cur.val, curLongest);
        int right = longest(cur.right, cur.val, curLongest);
    }

    // 2. pure recursion
    int globalLongest = 0;
    public int longestIncreasingPath1(TreeNode root) {
        longest(root);
        return lognest;
    }
    private int longest(TreeNode root) {
        if (root == null) return 0;
        int left = longest(root.left);
        int right = longest(root.right);
        int longest = 1;
        if (root.left != null && root.val < root.left.val) longest = Math.max(longest, left + 1);
        if (root.right != null && root.val < root.right.val) longest = Math.max(longest, right + 1);
        globalLongest = Math.max(globalLongest, longest);
        return longest;
    }
}