## dp

	1. dp[i][j] = the number of unique paths at location (i, j)
	2. induction rule:
	    if grid[i][j] == 1: dp[i][j] = 0
	    else: dp[i][j] = dp[i][j - 1] + dp[i - 1][j]
	3. fill in order:
	    left -> right; up -> down
	4. base case:
	    dp[0][0] = 1
	    dp[i][0] = (dp[i - 1][0] == 1 && grid[i][0] == 0) ? 1 : 0
	    dp[0][j] = (dp[0][j - 1] == 1 && grid[0][j] == 0) ? 1 : 0
	5. result:
	    dp[m - 1][n - 1]
	6. optimize:
	    space can optimize from O(m * n) to O(n)

time: O(m * n)<br>
space: O(m * n) -> O(n)
