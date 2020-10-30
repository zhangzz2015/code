## bfs
We can use level order traverse to solve the problem. When using level order we can know that the next node of the target node is the answer.
### check the level size
When we encounter the target node, we can check whether the target node's index in the current level is the size - 1 of the current level's size.
### use null node to mark level
We can add a null node to the end of the current level.

time: O(n) - n is the number of nodes<br>
space: O(n)

## dfs
We can use dfs to traverse the graph. When we meet the target node, we can record the level and the next time we traverse to the node in the same level is the node we want to find. If we cannot reach the same level again we then the target node is the rightmost node in the current level.

time: O(2^n)<br>
space: O(n)
