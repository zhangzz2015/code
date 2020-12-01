# Find the maximum subset sum from an array, with the max limit.
## dp
we can use dynamic programming to solve this problem.

	1. dp[i] means the max weight using numbers from [0, i] under the limit ending at index i
	2. induction rule:
		dp[i] = max:
	                - array[i] <= capacity: array[i]
	                - array[i] + array[j] <= capacity: array[i] + array[j]
	                - array[i] + dp[j] <= capacity: array[i] + dp[j]
		0 <= j < i
	3. result:
		maintain a global max of each dp[i]
	4. base case:
		dp[0] = array[0] <= capacity ? array[0] : 0
	5. fill in order:
		from left to right
	6. cannot optimize 

time: O(n^2)<br>
space: O(n)
