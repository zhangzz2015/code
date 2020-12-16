## brutal force
we can start from the last element of the two strings and use two pointers each for a string and add from left to right. We also need a carry to store the carry when add.

if we are adding numbers with the dot, we need to find out the length difference and add “0” to the shorter one. Then add one by one.

time: O(n)<br>
space: O(n)
