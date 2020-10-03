# Given a binary search tree(could have duplicate values, rightsubtree >= root, leftsubtree \< root), find the integer that occurred most.
Because the numbers are sorted in the BST when we are traversing the BST with inorder traversal, we know that the same values are grouped together because they are sorted. Thus, we can traverse the tree and maintain a state about how many consecutive same elements for the current node, and how are the global max occurrence for one element uptil the current node.<br>

time: O(n) - n is the number of nodes in the tree<br>
space: O(height)