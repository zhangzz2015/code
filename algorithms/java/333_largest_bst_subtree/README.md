## pure recursion
We can use pure recursion to solve this problem. For each node we want to know whether this is a BST and the size of this BST. Thus we need mutiple return values.<br>
return:
1. min & max & whether this subtree is BST: to determine the BST
2. size: to determine whether this is the largest BST

For each node:<br>
- left.max < root.val < right.min and both subtrees are BST:
	- count size -> update the max
- else: do nothing and return

time: O(n)<br>
space: O(height)
