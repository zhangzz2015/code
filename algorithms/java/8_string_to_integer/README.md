## scan from left to right
We can scan from left to right, and use a sign to handle negative numbers. Also we need to handle overflow and underflow.<br>
when the result is greater or equal than MAX_VALUE/10 we cannot add another digit.
time: O(n)<br>
space: O(1)
