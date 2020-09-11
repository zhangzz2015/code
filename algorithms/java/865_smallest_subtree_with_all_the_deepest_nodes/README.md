#This wants us to get the lowest common ancestor of all the deepest leaf nodes.
## two pass solution
1. find all the deepest leaf nodes
2. LCA of k nodes

time: O(n + n)<br>
space: O(height)
## one pass solution
We can also use multi-return value to show the information of LCA and the deepest level to show which LCA are the LCA of the leaf nodes.<br>
- return LCA of the deepest level nodes and deepest level
- induction rule:
	- if (left.deepestLevel == right.deepestLevel) return root
	- else return the larger one

time: O(n)<br>
space: O(height)
