## BFS
### Basic BFS
We use do a basic BFS to traverse the graph, and populate the next pointer for each level.<br>
time: O(n)<br>
sapce: O(n)<br>
### Space Optimize
We can use a curNode to iterate the node in the nodes level by level from left to right. Also we need to record a prevNode which we can link prevNode.next to curNode. Also, we need a nextLevelHead to record the head of the next level.<br>
n is the number of nodes<br>
time: O(n)<br>
space: O(1)
## DFS
We can also use DFS to traverse the graph and record the tail nodes for each level.<br>
If we use a map to record the tail nodes for each level, it does not matter of pre/in/post order.<br>
time: O(n)<br>
space: O(height)