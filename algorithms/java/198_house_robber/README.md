## dp
We can use dynamic programming to solve this problem.<br>

	1. m[i] means the max value robbing house from index 0 to index i
	2. m[i] = max(m[i - 2] + houses[i], m[i - 1])
	3. result -> m[houses.length - 1]
		0 1 2 3 4 5 6
		x y y X x x x
		to fill X we need y
	4. base case:
	   m[0] = nums[0]
	   m[1] = max(nums[0], nums[1])
	5. fill in order
	   from left to right
	6. optimization
	   we only need i - 1 and i - 2 to fill the current

time: O(n)<br>
space: O(1)

## dfs memoization
We can use backtracking to find all the result and return the max, and we use moization to optimize the time.<br>
Each level we decide whether we use we choose to rob this index of house or not.<br>

time: O(2^n)<br>
space: O(n)
