## dp

	1. dp[i][j] = number of unique paths at location (i - 1, j - 1)
	2. induction rule:
	    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
	3. fill in order:
	    left to right, up to down
	4. base case:
	    dp[1][j] = 1
	5. result:
	    dp[m][n]
	6. optimization:
	    space can optimize from O(m * n) to O(n)

time: O(m * n)<br>
space: O(m * n) -> O(n)
