## Solution
We cannot use backtracking to to solve this problem, because we need the information about the subtree instead of the path information that passed down from root.<br>
Thus, we can use pure recursion to solve the problem.<br>
1. For each of the node as the root of the subtree, we need to determine if it is a uni-value tree.
2. uni-value tree:
    - leftsubtree is uni-value
    - rightsubtree is uni-value
    - root.val == root.left.val == root.right.val
    - root.left == root.right == null

time: O(n)<br>
space: O(height)
