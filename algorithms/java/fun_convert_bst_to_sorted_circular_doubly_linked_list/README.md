# Convert BST to sorted circular doubly Linked list in-place.
Using doubly linked list we can optimize the recursion method's return value if we can use a circular doubly linked list.
## traverse
We can do a inorder traverse.<br>
time: O(n)<br>
space: O(height)
## pure recursion
We flatten the left subtree into a sorted circular doubly linked list and the right subtree into a sorted circular doubly linked list, then conect then.<br>
time: O(n)<br>
space: O(height)

