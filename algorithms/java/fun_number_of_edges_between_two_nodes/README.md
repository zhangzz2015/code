# Given a binary tree, and two nodes in the binary tree, find the distance(# of edges) between them.

					-5
				  /    \
				 2     -2
			    / \    / \
			   3   4  9  -6
			distance(node(3),node(4)) -> 2
			distance(node(-5), node(2)) -> 1

## solution
We can use pure recursion to solve the problem.<br>
- return the lca we found and the distance from the target node to current node.
- induction rule
	- if nothing found and all of the nodes were found we return -1
	- if found one target return the distance from that target to the current node

time: O(n)<br>
space: O(height)
