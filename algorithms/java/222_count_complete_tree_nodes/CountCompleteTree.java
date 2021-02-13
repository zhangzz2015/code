public class CountCompleteTree {
    public int countCompleteTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1;
        TreeNode leftNode = root.left;
        while (leftNode != null) {
            left++;
            leftNode = leftNode.left;
        }
        int right = 1;
        TreeNode rightNode = root.right;
        while (rightNode != null) {
            right++;
            rightNode = rightNode.right;
        }
        if (left == right) {
            return Math.pow(2, x) - 1;
        }
        return countCompleteTree(root.left) + countCompleteTree(root.right) + 1;
    }

	// recursion
	public int countNodes1(TreeNode root) {
		if (root == null) return 0;
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if (leftHeight == rightHeight) {
			return (1 << leftHeight) + countNodes(root.right);
		}
		return (1 << rightHeight) + countNodes(root.left);
	}

	// iterative
	public int countNodes2(TreeNode root) {
		int count = 0;
		while (root != null) {
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);
			if (leftHeight == rightHeight) {
				count += 1 << leftHeight;
				root = root.right;
			} else {
				count += 1 << rightHeight;
				root = root.left;
			}
		}
		return count;
	}

	private int getHeight(TreeNode root) {
		int height = 0;
		while (root != null) {
			height++;
			root = root.left;
		}
		return height;
	}
}
