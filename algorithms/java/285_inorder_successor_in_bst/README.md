## solution
We will search for that target in the BST. And there are three cases for a node find in the BST for its successor.<br>
1. The successor is the grandparent of the target.
2. The successor is the smallest element in the right subtree.
3. The successor not exist.

If the target has a right subtree then we go and find the smallest element in the right subtree. If the target do not have a right subtree and that is the largest element in the tree which means it doesn't have larger element among all its successors. Thus, we need to record a prev node which represents the closest element larger than the target.<br>
time: O(height)<br>
space: O(1)
