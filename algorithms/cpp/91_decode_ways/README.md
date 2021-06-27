## dp

	1. dp[i] means the number of ways to decode using first i number
	2. induction rule:
	    if s[i - 1] >= '1': dp[i] = dp[i - 1]
	    if s[i - 2] == '1' || (s[i -2] == '2' && s[i - 1] < '7'):
	        dp[i] += dp[i - 2]
	3. filling order:
	    left -> right
	4. base case:
	    dp[0] = 1, dp[1] = s[0] == '0' ? 0 : 1
	5. result:
	    dp[n]
	6. optimize:
	    space can optimize to O(1)

time: O(n)<br>
space: O(n) -> O(1)
