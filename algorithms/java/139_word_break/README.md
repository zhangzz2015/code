## dp

	1. dp[i] means first i letters can be constructed by the words in the word dictionary
	2. induction rule:
	     dp[i] = true if dp[j] == true && string[j,i] is in the word dictionary.
	     for j where j is [0,i)
	3. base case:
	     dp[0] = true
	     xxxxxxX
	4. result:
	     dp[n]
	5. fill in order:
	     from left to right
	6. cannot optimize: we need all information before

time: O(n^3)<br>
space: O(n)
