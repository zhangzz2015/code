## BFS
We can use BFS to traverse the tree. If we find a null node then we cannot meet another null node.<br>
time: O(n)<br>
space: O(n)
## recursion
We want to know the positoin of the rightmost leaf node at the largest level.<br>
case 1: the rightmost leaf node at left subtree
- left subtree is complete tree
- right subtree is perfect tree
- height(left subtree) == height(right subtree) + 1
case 2: the rightmost leaf node at right subtree
- left subtree is perfect tree
- right subtree is complete tree
- height(left subtree) == height(right subtree)

time: O(n)<br>
space: O(logn)