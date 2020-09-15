# Given a binary tree, randomly get a node.
This means each node has the same probability to be returned.<br>
## transfer into TreeNode[]
A naive way would be traverse the tree and transfer the tree nodes into an array. Then we know the size of the array and we have random access. We can do sampling.<br>
time: O(n)<br>
## using iterator
time: O(n)<br>
space: O(height) without parent pointer O(1) with parent pointer
## divide & conquer
- left subtree -> sample of the left subtree + weight of the left subtree
- right subtree -> sample of the right subtree + weight of the right subtree
- root

    [0, left.size - 1] [left.size, left.size + right.size -1] [root]
       left sample                right sample                 root

time: O(n)<br>
space: O(height)
