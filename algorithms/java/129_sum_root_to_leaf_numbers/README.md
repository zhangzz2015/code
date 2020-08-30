## backtracking
We can use backtracking to solve this problem. We need to maintain a current path sum in while traversing through all the path. And we need to add the current path sum to the total sum if we reach a leaf node.<br>
time: O(n) - n is the number of the nodes in the tree<br>
space: O(height)