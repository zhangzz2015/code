class HoursOfBurnDown {
	public int calHours(TreeNode root, TreeNode start) {
		if (start == null) {
			// not on fire
			return Integer.MAX_VALUE;
		}
		int[] max = new int[]{0};
		calHours(root, start, max);
		return max[0];
	}
	private int calHours(TreeNode root, TreeNode start, int[] max) {
		if (root == null) return 0;
		int left = calHours(root.left, start, max);
		int right = calHours(root.right, start, max);
		if (root == start) {
			max[0] = Math.max(max[0], Math.max(left, right) + 1);
			return -1;
		}
		if (left >= 0 && right >= 0) {
			return Math.max(left, right) + 1;
		} else if (left < 0) {
			max[0] = Math.max(max[0], right - left);
			return left - 1;
		} else {
			// right < 0
			max[0] = Math.max(max[0], left - right);
			return right - 1;
		}
	}
}
