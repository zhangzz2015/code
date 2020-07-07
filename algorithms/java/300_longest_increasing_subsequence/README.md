## Solution 1
We can use dynamic programming to solve this problem.<br>
definition: using subarray[0, i], longest increasing subsequence ending at index i.<br>
induction rule: dp[i] = max(dp[i] + 1, 1) where j < i && array[j] < array[i]
time: O(n^2)
space: O(n)

## Solution 2
This is kind of a greedy way. sequence[] we store the subsequence in the position of index 0 to index of found replacement index. For each element int the array we use binary search to find the index that the element can be fit into the array, and we replace that in the sequence[]. We can always replace that because smaller elements can replace the larger element without breaking the rule and have can have more options for elements after.<br>
time: O(nlogn)
space: O(n)