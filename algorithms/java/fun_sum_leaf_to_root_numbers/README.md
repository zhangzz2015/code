## backtracking
1. We can use backtracking to go through all the path from root to each of the leaf nodes.<br>
2. What we need to pass down:
    - need to know the contribution of cur node (10^level)
    - cur path value
time: O(n) - n is the number of nodes<br>
space: O(height)
## pure recursion
For each node, we return: <sum of all paths, # of leaf nodes>0
time: O(n) - n is the number of nodes<br>
space: O(height)
