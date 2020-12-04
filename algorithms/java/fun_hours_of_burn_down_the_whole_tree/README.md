# Given a binary tree, and a random node in it which is on fire, it will burn a level of node in one hour, then return the total number of hours to burn down the whole tree.
For example the start node is node 24.

			            10
			       /           \
			      5             25
			    /   \         /    \
			   2     7       21     30
			                /  \
			               20   24(start)
			              /     / \
			             18    23  26
			            /  \
			           17  19

For this problem, we want to find the node that has the max distance to the first starting node.<br>
We can use recursion to solve the problem.<br>
1. get from the child: the max distance from leave to the current node or the distance from the starting node.
2. on the current node: 
	- if the current root node is the first burning node: update the max with the max height with that subtree.
	- if there are two nodes from the leave: do nothing
	- if there is one node from the leave and one from the burning node: calculate the max distance from the start burning node to the other nodes in the subtree with the current node as the root and update the global max.
3. return: 
	- if there are two nodes from the leave: return the max height
	- if there is one node from the leave and one from the burning node: return the distance from the start burning node to the current node + 1.

To denote two different kinds return value, we can return two values one is the max distance from the leave and the max distance from the start burning node. Because the distance from the leave is always larger than 0 and we only need one of them in one path, we can return the negative value to represent the distance from the start burning node.

time: O(n) - n is the number of nodes in the tree<br>
space: O(height)
