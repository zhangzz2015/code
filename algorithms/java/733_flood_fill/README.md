## Graph Representation
- vertex: (i, j) position in the original graph
- neighbor: 4 directions with the **same color**

for a given init vertex, traverse all the reachable vertices.<br>
We can use both dfs and bfs
## dfs
time: O(V + E), worst case O(n^2 + 4 * n^2) = O(n^2)<br>
space: O(n^2) worst case: the longest depth of the path in dfs, O(V)
## bfs
time: O(V + E), worst case: O(n^2 + 4 * n^2) = O(n^2)<br>
space: O(2n) worst case: go out for 4 directions. The largest cycle. At most will be be more than the circumference.

					2
				  2 1 2
				2 1 0 1 2
				  2 1 2
				    2