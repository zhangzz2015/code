# Find the lowest common ancestor, where the treenode class has a parent pointer.
The given two nodes are not guaranteed to be in the binary tree.

	class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode parent;
	}

We can find two of the nodes seperately and record the number of levels of the nodes. And for the lower node we let them go up to the same level with the higher node. And let both of the nodes go up and stop at where they are at the same node.<br>
time: O(2 * height + height) -> O(height)<br>
space: O(1)
