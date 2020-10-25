## dp
We can use dynamic programming to solve this problem.

	1. m[i] means the minimum jump from index 0 to index i
	2. induction rule:
		m[i] = min of all m[j] + 1 where 0 <= j < i and m[j] is reachable from the start.
		else m[i] is not reachable
		(To represent not reachable we can use a special value)
	3. result: m[m.length - 1]
	4. fill in order:
		yyyyyyyyyX
		to fille x we need all the y from index 0 to index of X - 1.
		thus we need to fill in from left to right
	5. base case:
		m[0] = 0
	6. no optimization

time: O(n^2)<br>
space: O(n)
## bfs
vertex: index i<br>
edges(neighbors): from index i, what are all the indices reachable from i by jump indeces range:[i + 1, min(array.length - 1, i = array[i])], and all the weight of the edge is 1.<br>
On this graph, we want to solve the shortest path from vertex 0 to vertex n - 1.<br>
We can use bfs.

time: O(E + V)<br>
space: O(V)
