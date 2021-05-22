# Return the start and end index of the maximum subarray in the given array.

## dp

	1. dp[i] = the max subarray sum ending at index i
	2. induction rule:
	       if dp[i - 1] >= 0: dp[i] = dp[i - 1] + nums[i]
	       else: dp[i] = nums[i], start = i
	       update the max_sum and start and end index
	3. result:
	       return the updated start and end index
	4. fill in order:
	       left to right
	5. base case:
	       dp[0] = nums[0]
	6. optimize:
	       we only depending on the element before, thus we can optimize space to O(1)

time: O(n)<br>
space: O(1)
