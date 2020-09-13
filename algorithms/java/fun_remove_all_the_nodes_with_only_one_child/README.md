# Given a binary tree. Remove all the nodes with only one child

					5                    5
				  /   \                /   \
				 2     3              1     3
				/            ->      / \
			   1                    4   6
			  / \
			 4   6

## solution
We can use pure recursion to solve the problem.<br>
definition of recursion: return the tree with all one child nodes are removed<br>
induction rule:<br>
TreeNode left = helper(root.left)<br>
TreeNode right = helper(root.right)<br>
- if (left == null && right == null) zero child node -> return root
- if (left != null && right != null) two child node -> connect return root
- return not null one, because need to to delete this root node so return the child that need to connect to the root's parent.

time: O(n) -> n is the numebr of nodes<br>
space: O(height)
