## recursion
We can use recursion to construct the tree.<br>
We want to get all the possible roots from left subtree and right subtree.<br>
Combine all the possible left substree and right subtree to the current root.<br>
return the new list.

time: O(n * n * n)<br>
space: O(height)
