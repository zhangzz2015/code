# Find the kth largest node in BST
## solution 1: recursion
We can maintain a list of all tree node values from large to small. When size reaches k we prune all the branches and return.
Time: O(height + k)<br>
Space: O(height) call stack
## solution 2: reverse inorder iterator(from large to small)
We can use an iterator from large to small which means first traversel right subtree then root then left subtree.
Time: O(height + k)<br>
Space: O(height) using stack

