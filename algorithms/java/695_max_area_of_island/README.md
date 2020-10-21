## dfs
We can traverse the graph with dfs can mark visited. For each connected area we count the size of area that is included.

time: O(E + V) -> O(m * n + 4 * m * n) -> O(m * n)<br>
space: O(V) -> O(m * n)

## bfs
We can also use bfs to traverse each connected area, and count the size of the area that is included.

time: O(m * n)<br>
space: O(m * n)
