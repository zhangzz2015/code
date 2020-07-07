## Solution 1
We can use dynamic programming to solve this problem.<br>
definition: using subarray[0, i], longest increasing subsequence ending at index i.<br>
induction rule: dp[i] = max(dp[i] + 1, 1) where j < i && array[j] < array[i]
time: O(n^2)
space: O(n)

## Solution 2
for the searching part we can use binary search to optimize the time complexity.<br>
time: O(nlogn)
space: O(n)