# Change value of each node in the BST to the sum of all the nodes <= its own value.
## inorder traversal
We can use inorder traversal to traverse a tree and maintain a prefixsum global variable. Update whenever we reach a node.<br>
time: O(n) - n is the number of nodes in the tree<br>
space: O(height)
## add the return value and the passing down parameter
For a node, the prefixsum can be consist of the root to current node path sum and the left subtree sum. We can pass down a path value and return the subtree value.<br>
time: O(n)<br>
space: O(height)
## The return value can be the prefixsum of all the nodes already traversed
The return value is prefixsum of all the nodes already traversed.<br>
time: O(n)<br>
space: O(height)
