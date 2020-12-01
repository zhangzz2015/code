## dp

	1. dp[i] means the number of ways we have using the nums to sum up to target.
	2. incudtion rule:
	     dp[i] = dp[i - num[0]] + dp[i - num[1]]+ .. dp[i - num[num.length - ]] if all the index is valid
	3. result:
	     the result would be dp[target]
	4. fill in order:
		 left to right
	5. base case:
	     dp[0] = 1
	6. cannot optimize

time: O(target * n) - n is the number of elements in nums<br>
space: O(target)
