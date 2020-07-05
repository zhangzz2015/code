## Solution 1
We can regard the matrix as an array row by row, and search in an array.<br>
time: O(log(m * n))<br>
space: O(1)

## Solution 2
This is also young's matrix.<br>
Using the binary search tree view of the matrix(the heap view might not be very helpful), start from the top right corner.<br>
for each step:<br>
if current > target, go left<br>
if current < target, go down<br>
**time: O(m + n)**<br>
space: O(1)