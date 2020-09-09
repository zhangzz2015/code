public class LargestBST {
	public int largestBSTSubtree(TreeNode root) {
		if (root == null) return 0;
		largestBST(root);
		return largest;
	}
	private int largest = 0;
	private ReturnType largestBST(TreeNode root) {
		if (root == null) {
			return new ReturnType(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
		}
		ReturnType left = largestBST(root.left);
		ReturnType right = largestBST(root.right);
		if (left.isBST && left.max < root.val && right.isBST && root.val < right.min) {
			largest = Math.max(largest, left.size + right.size + 1);
			return new ReturnType(Math.min(left.min, root.val), Math.max(right.max, root.val), left.size + right.size + 1, true);
		}
		return new ReturnType(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, false);
	}
	
	static class ReturnType {
		int min;
		int max;
		int size;
		boolean isBST;
		ReturnType(int min, int max, int size, boolean isBST) {
			this.min = min;
			this.max = max;
			this.size = size;
			this.isBST = isBST;
		}
	}
}
