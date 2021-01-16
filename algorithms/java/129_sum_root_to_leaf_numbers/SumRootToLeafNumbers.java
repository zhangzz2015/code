public class SumRootToLeafNumbers {
    
    // 1. backtracking
    public int sumNumbers1(TreeNode root) {
        int[] total = new int[]{0};
        sum(root, 0, total);
        return total[0];
    }
    private void sum1(TreeNode cur, int curPathSum, int[] total) {
        if (root == null) return;
        curPathSum = curPathSum * 10 + cur.val;
        if (cur.left == null && cur.right == null) {
            total[0] += curPathSum;
            return;
        }
        sum(cur.left, curPathSum, total);
        sum(cur.right, curPathSum, total);
    }
    // 2. another kind of backtracking using lead node as the base case
    public int sumNumbers2(TreeNode root) {
        int[] total = new int[]{0};
        if (root == null) return 0;
        sum2(root, 0, total);
        return total[0];
    }
    private void sum2(TreeNode cur, int curPathSum, int[] total) {
        if (cur.left == null && cur.right == null) {
            curPathSum = curPathSum * 10 + cur.val;
            total[0] += curPathSum;
            return;
        }
        curPathSum = curPathSum * 10 + cur.val;
        if (root.left != null) sum2(cur.left, curPathSum, total);
        if (root.right != null) sum2(cur.right, curPathSum, total);
    }

    // using recursion
    public int sumNumbers3(TreeNode root) {
        return sum3(root, 0);
    }
    private int sum3(TreeNode cur, int curPathValue) {
        if (cur == null) return 0;
        curPathValue = curPathValue * 10 + cur.val;
        if (cur.left == null && cur.right == null) {
            return curPathValue;
        }
        return sum3(cur.left, curPathValue) + sum3(cur.right, curPathValue);
    }
}
