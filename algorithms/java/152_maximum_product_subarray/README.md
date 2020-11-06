## dp

	1. dp[i] means the maxProduct ending at index i
	2. induction rule:
		dp[i] = max{array[i], array[i] * dp[i - 1], array[i] * min[i - 1]}
		because we can have negative numbers, the current number times smallest number may also be the max
	3. result:
		max amoung all the dp[i]
	4. fill in order:
		from left to right
	5. base case:
		dp[0] = array[0]
	6. optimization:
		we only need the max and min for index - 1
	
	time: O(n)
	space: O(1)
