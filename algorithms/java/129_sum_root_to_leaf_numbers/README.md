## backtracking
We can use backtracking to solve this problem. We need to maintain a current path sum in while traversing through all the path. And we need to add the current path sum to the total sum if we reach a leaf node.<br>
time: O(n) - n is the number of the nodes in the tree<br>
space: O(height)
## recursion
We can also use recursion to solve the problem.<br>
input: subtree root, and current sum of a path from root to the subtree root.<br>
output: sum of numbers constructed by all the paths from that subtree root and the current number prefix.<br>
induction rule:<br>
1. add the current root number digit to the curSum
2. if root is leaf: return the sum
3. else: return the sum of left subtree building on the current sum and the sum of right subtree on the current sum.

time: O(n)<br>
space: O(height)
