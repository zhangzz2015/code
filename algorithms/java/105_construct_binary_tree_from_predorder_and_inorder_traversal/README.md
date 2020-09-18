## recursion
We can use recursion to solve the problem, which is find the root, construct the left subtree, and construct the right subtree.<br>
- identify the foot -> using preorder
- identify the boundary of left and right subtree -> using inorder
- construct the left subtree and the right subtree recursively

We can use a map to store the reverted index of inorder.<br>
We can also do both preorder and inorder at the same time<br>
time: O(n)<br>
space: O(height)
