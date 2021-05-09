## stack
We can use a stack to store the left parentheses.<br>
When we encounter a right parentheses, we need to check whether the left parentheses if match to the current top of the stack.<br>
When we encounter a left parentheses, we push that to the stack.

time: O(n)<br>
space: O(n/2)
