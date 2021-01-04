## topological order
We can build the graph and traverse the graph in topological order.

### dfs
Using dfs, the edge of the graph would be direct graph.<br>
For an edge [a,b] meaning need to take b before a.<br>
Thus, b would be in a's neighbor.

### bfs
Using bfs, the edge of the graph would be direct graph.<br>
We also need to create an indegree map.<br>
For an edge [a,b] meaning need to take b before a.<br>
Thus, a would be in b's neighbor. indegree[a]++<br>

time: O(E + E + V)<br>
space: O(E + V)
