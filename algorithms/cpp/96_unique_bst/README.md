## dp

	1. dp[i] means the number of structurally unique bst which has i nodes
	2. induction rule:
	    dp[i] += dp[j - 1] * dp[i - j] for each j where j is [1,i]
	    each of the node from [1,j] can be the root of the tree
	3. filling order:
	    left -> right
	4. base case:
	    dp[0] = 1, dp[1] = 1
	5. result:
	    dp[n]

time: O(n^2)<br>
space: O(n)
