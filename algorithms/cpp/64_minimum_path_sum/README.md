## dp

	1. dp[i][j] = the shortest path sum from top left to (i, j)
	2. induction rule:
	    dp[i][j] = grid[i][j] + min(dp[i - 1][j], dp[i][j - 1])
	3. fill in order:
	    left -> right, up -> down
	4. base case:
	    dp[i][j] = grid[0][0]
	    dp[i][0] = dp[i - 1][0] + grid[i][0]
	    dp[0][j] = dp[0][j - 1] + grid[0][j]
	5. result:
	    dp[m - 1][n - 1]
	6. optimize:
	    space can optimize from O(m * n) to O(n)

time: O(m * n)<br>
space: O(m * n) -> O(n)
