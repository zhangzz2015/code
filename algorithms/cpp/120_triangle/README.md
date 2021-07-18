## dp

	1. dp[i][j] means the smallest path sum from the bottom to the current spot
	2. induction rule
	    dp[i][j] = min(dp[i + 1][j + 1], dp[i + 1][j]) + triangle[i][j]
	3. filling order
	    bottom -> up, left -> right
	4. base case
	    dp[m][j] = last row of the triangle
	5. result
	    dp[0][0]
	6. optimize
	    space optimize from O(m * n) -> O(m)

time: O(m * m / 2)<br>
space: O(m * m) -> O(m)	
