## traverse
We can traverse the BST in inorder, for each of the node we can linked the current to the node before this node in the inorder, and link prev node to the current node. After the traverse finishes we can link the head and the tail together.

time: O(n)<br>
space: O(height)

## recursion
For each recursion:<br>
- the input is the subtree root that we want to convert to DLL
- the output is the curcular DLL
- for a current node:
	- get the left subtree's DLL and the right subtree's DLL
	- link left part to the current node the current node to the right half

time: O(n)<br>
space: O(height)
