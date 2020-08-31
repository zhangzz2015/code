# Longest increasing path following parent -> child direction in binary tree
             9
          /     \
         2       3
       /   \    /  \  
      -4    5  -3  -7 
     /  \   / \
    6    1 6   1
          / \ 
         3   4
    return 3, the longest increasing path is [2, 5, 6]

## backtracking
When we are using backtracking we are tracking on a path to see the longest increasing path. That transforms to a longest increasing subarray in the traversing path.<br>
For all the paths:<br>
- for each node, finding the longest increasing path ending at the cur node.

The information we need to pass down is:
- prevLongest
- prevNodeValue

time: O(n)<br>
space: O(height)
## pure recursion
For all paths:
- for each node, finding the longest increasing path **starting at cur node**.

Returning value: longest increasing path starting from root(including root)

time: O(n)<br>
space: O(height)