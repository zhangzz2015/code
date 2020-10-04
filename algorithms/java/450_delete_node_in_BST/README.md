## recursion
We can use recursion to solve the problem. The recursion will return the root of the subtree with the node deleted. We can divide all possible cases with 3 cases.<br>
1. target.left == null (include the case of target is leaf)
    - return target.right
2. target.right == null
    - return target.left
3. target has both left and right child: we want to find the smallest node in the right subtree, delete that node, and create a new node with that value and use that to create a new node as the return subtree root
    - if target.right has no leftsubtree return right subtree.
    - if target.right has leftsubtree find the smallest in that subtree.

time: O(height)<br>
space: O(height)