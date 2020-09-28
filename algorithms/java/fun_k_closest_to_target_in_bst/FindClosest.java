class FindClosest {
    public static class AscIterator {
        private Deque<TreeNode> stack = new LinkedList<>();
        
        public AscIterator(TreeNode root, int target) {
            // find smallest larger with O(logn)
            TreeNode cur = root;
            while (cur != null) {
                if (cur.val <= target) {
                    cur = cur.right;
                } else {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public TreeNode next() {
            // amortized O(1)
            if (!hasNext()) {
               throw new NoSuchElementException();
            }
            TreeNode cur = stack.pop();
            TreeNode res = cur;
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            return res;
        }
    }

    public static class DesIterator {
        private Deque<TreeNode> stack = new LinkedList<>();

        public DesIterator(TreeNode root, int target) {
            // find largest smaller with O(logn)
            TreeNode cur = root;
            while (cur != null) {
                if (cur.val >= target) {
                    cur = cur.left;
                } else {
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public TreeNode next() {
            // amortized O(1)
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            TreeNode cur = stack.pop();
            TreeNode res = cur;
            cur = cur.left;
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            return res;
        }
    }

    public List<Integer> findKClosest(TreeNode root, int k, int target) {
        AscIterator ascIterator = new AscIterator(root, target);
        DesIterator desIterator = new DesIterator(root, target);
        TreeNode smallestLarger = ascIterator.next();
        TreeNode largestSmaller = desIterator.next();
        for (int i = 0; i < k; i++) {
            if (target - largestSmaller.val < smallestLarger.val - target) {
                res.add(largestSmaller.val);
                largestSmaller = desIterator.next();
            } else {
                res.add(smallestLarger.val);
                smallestLarger = ascIterator.next();
            }
        }
        return res;
    }
}

