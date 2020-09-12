public class NumberOfEdges {
	public int distance(TreeNode root, TreeNode one, TreeNode two) {
		if (one == two) return 0;
		int[] res = new int[]{-1};
		distance(root, one, two, res);
		return res[0];
	}

	private int distance(TreeNode root, TreeNode one, TreeNode two, int[] res) {
		if (root == null) return -1;
		int left = distance(root.left, one, two, res);
		int right = distance(root.right, one, two, res);
		if (left != -1 && right != -1) {
			// one node on each side
			res[0] = left + right;
			// found answer return -1
			return -1;
		}
		if (root == one || root == two) {
			// if we found one node
			if (left == -1 && right == -1)  {
				// the other node is not in this substree, distance to the next parent is 1
				return 1;
			}
			// one node is the other node's ancestor
			res[0] = left != -1 ? left : right;
			// found answer return -1
			return -1;
		}
		if (left != -1) {
			return left + 1;
		}
		if (right != -1) {
			return right + 1;
		}
		// if found nothing on both sides return -1
		return -1;
	}
}
