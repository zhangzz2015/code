## recursion
We can use recursion to solve this problem.<br>
We will need to use a blobal TreeNode to record a previous TreeNode, and do a preorder traversal and link the current node to the previous node.<be>
Because this is preorder and we wil use the right pointer as the nexxt pointer of the linkdelist. We will change the tree structure of the node's right pointer, so we need to record the original right node of the root and do recursion on that node.<br>
time: O(n)<br>
space: O(height) -> O(n)
