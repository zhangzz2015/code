## dp
We can use dynamic programming to solve this problem.

	1. m[i] means whether we can reach index i from index 0.
	2. induction rule:
			m[i] = true: there exists j (0 <= j < i) that m[j] is true and j + array[j] >= i
			m[i] = false: else
	3. result: m[array.lenghth - 1]
	4. fill in order:
			yyyyyyyyX
		to fill in X we need all the y before X, thus we fill from left to right
	5. base case:
		m[0] = true
	6. no optimization.

time: O(n^2)<br>
space: O(n)

## greedy
Keep update the max can reach area.<br>

time: O(n)<br>
space: O(1)
