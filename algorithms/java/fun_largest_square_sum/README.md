## Given a 2-D n*n matrix, find the largest square sum。
<pre>
2, 3, -4, 1
-5, 1, 2, -2
3, 2, 0, -3
-1, 5, 2, 1
</pre>
This is not exactly a dynamic programming problem. But when we are calculating the prefix sum(a rectangle area from point (0, 0) to point (i, j)) of matrix.
The brutal force way is for every row and col as the left up corner and find out each possible length and maintain a global max.<br>
For calculating the sum of each column in the matrix we can use a preprocessed prefix sum of the original matrix to calculate the answer.<br>
time: O(n^3)<br>
space: O(n)
