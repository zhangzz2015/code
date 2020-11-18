## backtracking
We can use dfs backtracking to traverse all the paths.<br>
There are n levels, for each level:<br>
we can choose all the nodes with indegree 0.<br>
Becasue we want to know the indegrees of each nodes, we can use a hashmap to store the matching from node to their indegrees.

time: O((# of possible 0 indegree nodes) ^ n) - n is the number of all nodes<br>
space: O(n)
