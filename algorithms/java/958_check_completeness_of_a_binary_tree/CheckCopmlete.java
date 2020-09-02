public class CheckCopmlete {
    
    // 1.1 BFS check at generate
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.left);
            }
            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
    // 1.2 BFS check at expand
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>(); // LinkedList can add null value
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return true;
    }

    // 2. recursion
    class ReturnType {
        boolean isPerfect;
        boolean isComplete;
        int height;
        ReturnType(boolean isPerfect, boolean isComplete, int height) {
            this.isPerfect = isPerfect;
            this.isComplete = isComplete;
            this.height = height;
        }
    }
    
    public boolean isCompleteTree(TreeNode root) {
        return helper(root).isComplete;
    }
    private ReturnType helper(TreeNode root) {
        if (root == null) return new ReturnType(true, true, 0);
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);
        boolean isPerfect = left.isPerfect && right.isPerfect && left.height == right.height;
        boolean isComplete = (left.isComplete && right.isPerfect && left.height == right.height + 1) || (left.isPerfect && right.isComplete && left.height == right.height);
        return new ReturnType(isPerfect, isComplete, Math.max(left.height + 1, right.height + 1));
    }
}
