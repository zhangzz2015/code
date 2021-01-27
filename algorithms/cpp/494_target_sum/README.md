## dynamic programming

	1. dp[i][j] means number of ways using first i numbers sum up to j - sum
	2. induction rule:
	      if dp[i][j] has some ways to reach, then they can reach to dp[i + 1][j - nums[i]] and dp[i + 1][j + nums[i]]
	3. base case:
	          -sum ... 0 ... sum
	        0          1
	        1     
	        2      y
	        3    X   X
	        4
	        5
	4. result:
	      dp[n][S + sum]
	5. fill in order:
	      from left to right, up to down
	6. can optimize to one row

time: O(n * sum)<br>
space: O(n * sum) -> O(sum)

## knapsack
We can devide the elements into two knapsacks, one is for putting + and the other is putting -.<br>
sum(+) - sum(-) = S, and we can transfer the equation<br>
sum(+) + sum(+) = S + sum(-) + sum(+)<br>
2 * sum(+) = S + sum(all)<br>
sum(+) = (S + sum(all)) / 2<br>
So if (sum of all +) equal to (S + sum of all), choosing all the elements in + and all others to - can make the result S.<br>

time: O(n * (S + sum(all)))<br>
space: O(S + sum(all))
