# 直上直下 any to any - largest path<br>We want to find the largest path sum of a subpath in leaf to root, can start and end in any node. 

## backtracking
For each node: find the largest sum ending at the current node.<br>
Information we need to pass down:<br>
largest path sum ending at prev node.
time: O(n)<br>
space: O(height)

## pure recursion
For each node: find the largest sum starting from the current node.<br>
Return the largest path sum starting from root(including root).<br>
time: O(n)<br>
space: O(height)

