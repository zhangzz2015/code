## dp
We can use dynamic programming to solve this problem

	1. boolean dp[i][j] means using substring index [i, j] is palindrom
	2. induction rule:
		dp[i][j] = true: s[i] == s[j] && dp[i + 1][j - 1] 
	               false: else
	3. result:
		record longest: if dp[i][j] == true: longest = max(longest, j - i + 1)
	4. base case:
		i == j: dp[i][j] = true;
		i == j - 1: && s[i] == s[j] == true;
	5. fill in order:
		
	    0 1 2 3 4
	  0 x x x X x
	  1   x z x x
	  2     x x x  
	  3       x x
	  4         x

	  bottom -> up, left -> right
	
time: O(n^2)<br>
space: O(n^2)
