# Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.

                -7
               /   \
              4     6
             / \    /
            1   5  -8
               /
              -3
        target = 9, return true path(4 + 5) == 9
        target = 7, return false
Because we want to find a up to down path, we can use backtracking.<br>
For each of the root -> leaf paths: subarray sum equals target<br>
Because we are finding the subarray sum, we can use prefix sum.<br>
array = {-7, 4, 5, -3}<br>
prefix = {**0**, -7, -3, 2, -1}<br>
subarraySum(i, j) = prefix[j] - prefix[i - 1]<br>
all the paths:<br>
- for each node: finding if there is any path ending at cur node with sum equals target.<br>
The information we need to pass down:<br>
    1. prefixSums(before the current node) - set
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

follow up 1: [number of path sum to a given target number](../437_path_sum_3/README.md) [leetcode](https://leetcode.com/problems/path-sum-iii/) [Java](../437_path_sum_3/PathSum.java)
follow up 2: [what if it is product to target](../fun_path_product_to_target/README.md) [Java](../fun_path_product_to_target/ProctToTarget.java)