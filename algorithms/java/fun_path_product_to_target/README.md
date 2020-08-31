# Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the product of the numbers on the path is the given target number.

                -7
               /   \
              4     6
             / \    /
            1   5  -8
               /
              -3
        target = -28, return true path(-7 * 4) == 28
        target = 7, return false
Because we want to find a up to down path, we can use backtracking.<br>
For each of the root -> leaf paths: subarray product equals target<br>
Because we are finding the subarray product, we can use prefix prodcut.<br>
subarrayProduct(i, j) = prefix[j] / prefix[i - 1]<br>
**But when meeting a zero node, we need to clear out all the prefixProducts, or use a new Map of prefixProducts.**
all the paths:<br>
- for each node: finding if there is any path ending at cur node with product equals target.<br>
The information we need to pass down:<br>
    1. prefixProducts(before the current node) - set
    2. prevProduct(the sum of the current path)

      We need to notice when we do recovery of backtracking. We need to know tha whether the curSum is added at this function call。
                4
              /   \
             3 (prefixProduct = 12)
            / \
           -2   1 (prefixProduct = 12)
          /
         2


time: O(n)<br>
space: O(height)