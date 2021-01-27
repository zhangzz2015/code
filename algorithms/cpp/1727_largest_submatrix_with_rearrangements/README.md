## greedy
We can count the number of consecutive 1 in each of the spot from top to down.<br>
We can iterator through each row of the consecutive 1s. We can sort the row int descending order, because puting largest in the front we can always us height[i] * (i + 1) to update the matrix area.

time: O(n * (n + nlogn))<br>
space: O(n)
