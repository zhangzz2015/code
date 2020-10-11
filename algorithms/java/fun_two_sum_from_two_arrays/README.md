# Given 2 sorted arrays, pick one element from each to form a tuple. How many tuples are there with sum \<= target.

Assume there are no duplicate elements in the arrays.<br>We can transfer this to a Young's matrix search target problem.<br>array1 = {1, 3, 6} - n<br>array2 = {2, 4, 5} - m<br>target = 7<br>int[][] matrix: "matrix[i][j] = array1[i] + array2[j]" -> this is a virtual formula<br>

        0  1  2
       ---------
    0 | 3  5  6 
    1 | 5  7  8
    2 | 8  10 11

We start from the top right.<br>
for each i (for each row):<br>
find the rightmost j where array1[i] + array2[j] <= target. update j + 1 to the result.

time: O(n + m)<br>
space: O(1)