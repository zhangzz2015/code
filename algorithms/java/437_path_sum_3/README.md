## backtracking
Because we want to find a up to down path, we can use backtracking.<br>
For each of the root -> leaf paths: subarray sum equals target<br>
Because we are finding the subarray sum, we can use prefix sum.<br>
array = {-7, 4, 5, -3}<br>
prefix = {**<0,1>**, <-7,1>, <-3,1>, <2,1>, <-1,1>}<br>
subarraySum(i, j) = prefix[j] - prefix[i - 1]<br>
all the paths:<br>
- for each node: finding if there is any path ending at cur node with sum equals target.<br>
The information we need to pass down:<br>
    1. prefixSums(before the current node) - HashSet
    2. prevSum(the sum of the current path)

      We need to notice when we do recovery of backtracking. We need to know tha whether the curSum is added at this function call。
                4
              /   \
             3 (prefixSum = 7)
            / \
           -2   1
          /
         2 (prefixSum = 7)


time: O(n)<br>
space: O(height)