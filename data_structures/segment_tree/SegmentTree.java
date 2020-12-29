class SegmentTree {

	/* space: O(n) */
	private int[] nums;
    private Node root;
    
    /* O(n) */
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        this.nums = nums;
        this.root = buildTree(this.nums, 0, this.nums.length - 1);
    }
    
    private Node buildTree(int[] nums, int start, int end) {
        if (start == end) return new Node(start, end, nums[start]);
        int mid = start + (end - start) / 2;
        Node left = buildTree(nums, start, mid);
        Node right = buildTree(nums, mid + 1, end);
        Node root = new Node (start, end, left.sum + right.sum);
        root.left = left;
        root.right = right;
        return root;
    }
    
    /* O(logn) */
    public void update(int i, int val) {
        int diff = val - nums[i];
        if (diff == 0) return;
        nums[i] = val;
        update(root, i, diff);
    }
    
    private void update(Node root, int index, int diff) {
        if (root == null || index > root.end || index < root.start) {
            return;
        }
        root.sum += diff;
        update(root.left, index, diff);
        update(root.right, index, diff);
    }
    
    
    /* O(logn) */
    public int sumRange(int i, int j) {
        if (root == null) return 0;
        return sumRange(root, i, j);
    }
    
    private int sumRange(Node root, int start, int end) {
        if (start > end) return 0;
        if (start == root.start && end == root.end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        return sumRange(root.left, start, Math.min(mid, end)) + sumRange(root.right, Math.max(mid + 1, start), end);
    }
    
    
    private static class Node {
        int start, end;
        int sum;
        Node left, right;
        public Node(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }
}
