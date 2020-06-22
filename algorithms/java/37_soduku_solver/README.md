To represent this sudoku game board we can use a 2D matrix of integer
int[][] board -> to represent empty we can use 0
We want to assume that the current board that gives us is already a valid board.

In high level, I want to use the dfs back-tracking method to solve this problem. Using a recursion tree can represent my idea.
For the recursion tree. The level is the number of slots that are not filled which in our case would be 0. For each level we decide which numbers are valid to fill in. For each level we at most have 9 options which are from 1 to 9.

Time: O(9 ^ 81)
Space: O(81)
