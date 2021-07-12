## dp

	1. dp[i][j] means the number of distinct subsequences using first i chars from s and first j chars from t.
	2. induction rule
	    dp[i][j] = dp[i - 1][j]
	    if s[i - 1] == t[j - 1]: dp[i][j] += dp[i - 1][j - 1]
	3. filling order
	    left to right, up to down
	4. base case
	    dp[i][0] = 1
	5. result
	    dp[m][n]
	6. optimize
	    space can optimize to O(n)

time: O(m * n)<br>
space: O(m * n) -> O(n)

