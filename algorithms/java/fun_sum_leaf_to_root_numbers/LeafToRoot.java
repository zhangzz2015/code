public class LeafToRoot {
    
    // 1. backtracking
    public int leafToRoot1(TreeNode root) {
        int[] total = new int[]{0};
        if (root == null) return 0;
        sum1(root, 1, 0);
        return total[0];
    }
    private void sum1(TreeNode cur, int factor, int curPathValue, int[] total) {
        curPathValue += cur.val * factor;
        if (cur.left == null && cur.right == null) {
            total[0] += curPathValue;
            return;
        }
        if (cur.left != null) sum1(cur.left, factor * 10, curPathValue);
        if (cur.right != null) sum1(cur.right, factor * 10, curPathValue);
    }

    // pure recursion
    class ReturnType {
        int sum;
        int leaves;
        public ReturnType(int sum, int leaves) {
            this.sum = sum;
            this.leaves = leaves;
        }
    }

    public int leafToRoot2(TreeNode root) {
        if (root == null) return 0;
        return sum2(root).sum;
    }
    private ReturnType sum2(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new ReturnType(root.val, 1);
        }
        int leaves = 0;
        int sum = 0;
        if (root.left != null) {
            ReturnType left = sum2(root.left);
            leaves += left.leaves;
            sum += left.sum;
        }
        if (root.right != null) {
            ReturnType right = sum(root.right);
            leaves += right.leaves;
            sum += right.sum;
        }
        return new ReturnType(sum * 10 + leaves * root.val, leaves);
    }
}