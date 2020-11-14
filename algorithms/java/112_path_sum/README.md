## backtracking
Because we want to find if we have a path from root to leaf that equal to the sum, we need to traverse all the path in the tree to determine whether there is the validate path sum.<br>
For the recursion tree:<br>
- each level we are deciding we choose for the left of the path or the right of the path.
- the level is the height of the tree.

time: O(n) - n is the number of the tree<br>
space: O(height)
