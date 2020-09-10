## pure recursion
We can use recursion to solve this problem. In this problem we assume that two nodes all exist in the tree.<br>
recursion definition: Lowest Common Ancestor of a and b
- both a and b in the subtree -> return LCA
- only one of a, b in the subtree -> return the node itself
- none of a, b in the subtree -> return null

		For one node:
			TreeNode left = LCA(root.left)
			TreeNode right = LCA(root.right)
			
			case 1: left == null && right == null
					if (root == a || root == b) return root;
					else return null
			case 2: left != null && right == null
					if (root == a || root == b) return root;
						return left;
						case 2.1: -> left subtree contains only 1 of a, b
						case 2.2: -> left subtree contains both a, b
			case 3: left == null && right != null
					symetric with case 2
			case 4: left != null && right != null
					return root
					a, b in two subtrees, root is the LCA
