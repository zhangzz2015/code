# Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum >= s.<br>Example:<br>input: s = 7, nums = [2, 3, 1, 2, 4, 3]<br>output:2<br>subarray [4, 3] has the minimal length under the problem constraint.

A subarray can be defined with the starting index and the ending index.<br>
Starting from the brutal force idea, we want to find all the subarray which has the sum >= s. This would take O(n^2) time.<br>

## sliding window
We can optimize with a sliding window method.<br>
for each j as the ending index:<br>
- find the rightmost i as the starting index where sum[i,j] >= target
- because the numbers in the array are all positive numbers, adding more elements into the subarray will only make the sum larger. For each j, when index we will never go searching on the left.

time: O(n)<br>
space: O(1)

