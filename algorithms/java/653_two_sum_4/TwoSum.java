class TwoSum {
	public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        AscIterator ascIterator = new AscIterator(root);
        DesIterator desIterator = new DesIterator(root);
        while (ascIterator.peek().val < desIterator.peek().val) {
            int sum = ascIterator.peek().val + desIterator.peek().val;
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                ascIterator.next();
            } else {
                desIterator.next();
            }
        }
        return false;
    }
    static abstract class MyIterator {
        Deque<TreeNode> stack;
        MyIterator(TreeNode root) {
            this.stack = new ArrayDeque<>();
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        public TreeNode getCur() {
            if (!hasNext()) {
                return null;
            }
            return stack.pop();
        }
        public abstract TreeNode next();
        public TreeNode peek() {
            return stack.peek();
        }
        protected void firstSmallestNode(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        protected void firstLargestNode(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
        }
    }
    static class AscIterator extends MyIterator {
        AscIterator(TreeNode root) {
            super(root);
            firstSmallestNode(root);
        }
        @Override
        public TreeNode next() {
            if (!hasNext()) {
                return null;
            }
            TreeNode cur = getCur();
            firstSmallestNode(cur.right);
            return cur;
        }
    }
    static class DesIterator extends MyIterator {
        DesIterator(TreeNode root) {
            super(root);
            firstLargestNode(root);
        }
        @Override
        public TreeNode next() {
            if (!hasNext()) {
                return null;
            }
            TreeNode cur = getCur();
            firstLargestNode(cur.left);
            return cur;
        }
    }
}
