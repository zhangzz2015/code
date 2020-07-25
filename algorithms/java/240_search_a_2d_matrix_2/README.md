## Solution
This is a young's matrix.<br>
Using the binary search tree view of the matrix(the heap view might not be very helpful), start from the top right corner.<br>
for each step:<br>
if current > target, go left<br>
if current < target, go down<br>
time: O(m + n)<br>
space: O(1)