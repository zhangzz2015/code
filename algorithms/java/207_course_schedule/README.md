## topological order
To model this graph<br>
vertex: course number<br>
edge(u -> v): course u depends on v<br>
this is a dependency graph<br>
1. construct the graph: use a map to store dependency graph
2. find can we have topological order

## dfs
The topological sort can be based on dfs

time: O(E + E + V) - build graph using edge, perform topological sort<br>
space: O(V)

## bfs
The topological sort can be based on bfs

time: O(E + V) - build the graph using all edge with O(E) and traverse using O(V)<br>
space: O(V) - need a map to record indegree and queue for bfs
