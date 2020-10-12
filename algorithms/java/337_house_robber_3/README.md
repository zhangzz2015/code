## recursion
We can use recursion to solve the problem.<br>
input: subtree root<br>
return: both rob this root max value and unrob this root max value<br>
induction rule:<br>
1. rob = left.unrob + right.unrob + root.val
2. unrob = Math.max(left.rob, left.unrob) + Maht.max(right.rob, right.unrob)

time: O(n)<br>
space: O(height)
## backtrakcing + memoization
return: max money of the substree of that root
induction rule:<br>
rob = root.val<br>
if left != null: rob += rob(root.left.left) + rob(root.left.right)<br>
if right != null: rob += rob(root.right.left) + rob(root.right.right)<br>
notRob = rob(root.left) + rob(root.right)<br>
return max(rob, notRob)

time: O(n)<br>
space: O(n)
