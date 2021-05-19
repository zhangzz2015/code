## use a stack
- if '(' comes:
	- push the '(' index to the stack
- if ')' comes:
	- if stack is empty: all matched before this is unvalid: update the start to current + 1
	- if stack is not empty: pop from the stack; if stack empty: update longest with end - start + 1; else: end - stack.top()

time: O(n)<br>
space: O(n)
## dp

	1. dp[i] means the longest valid parentheses substring ending at s[i - 1]
	2. induction rule:
	   we need to maintain a count of the current not matched '('
	   if s[i - 1] == '(': count++
	   if s[i - 1] == ')':
	      if count > 0: there are '(' left not matched
	           count--; dp[i] = 2;
	           if s[i - 2] == ')': add former length of closed ')'
               add the length of previous valid substring
	3. result: max(dp[i])
	4. fill in order:
	    xxxxxX  -> left to right
	5. base case:
	    dp[0] = 0

time: O(n)<br>
space: O(n)
