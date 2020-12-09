## dp

	1. dp[i][j] means the first i characters of S, the first j characters of P. Math or not.
	2. induction rule:
	   for the last element in P
	   - current element is character p[j - 1] != '*' && p[j - 1] != '.':
	     the current element match and characters before match
		 dp[i][j] = s[i - 1] == p[j - 1] && dp[i - 1][j - 1]
	   - current element is '.' p[j - 1] == '.':
	     can match any element so depending on the characters before match
	     dp[i][j] = dp[i - 1][j - 1]
	   - current element is '*' p[j - 1] == '*':
	     - if p[j - 2] == '.':
		   can match 0 or infinite
		   dp[i][j - 2] || dp[i - 1][j]
		 - else:
		   match 0 or match 1 or more of the same
		   dp[i][j - 2] || s[i - 1] == p[j - 2] && dp[i - 1][j]
	3. result: dp[m][n]
	    0 m m m m m m 
	   0
	   s
	   s
	   s     y y
	   s   y   X
	   s
	   
	4. base case:
	   dp[0][0] = true
	   dp[0][j > 0] = p[j - 1] == '*' && dp[0][j - 2]
	5. fill in order
	   left -> right
	   top -> bottom

time: O(m * n)<br>
space: O(m * n)
	     
