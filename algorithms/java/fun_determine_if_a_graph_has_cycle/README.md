# Determine if a graph has cycle.
## undirected graph
For an undirected graph, if there is a vertex is revisited then there is a cycle.<br>
We can use dfs with mark VISITED to solve the problem.

time: O(V + E)<br>
space: O(V)
## ditected graph
For an directed graph, even if a vertex has been revisited there may not be a cycle in the graph.


		    > N2
		  /      \     > N5
		N1     	  >   /    \
		  \       > N4      > N7
		   \     /   \      >
			> N3      \    /
			           > N6

Thus, we need to use dfs with mark VISITING or backtracking to solve this problem.

If using dfs with mark VISITING<br>
time: O(V + E)<br>
space: O(V)

If using backtracking<br>
time: O(b^V) b is the braches of each node<br>
space: O(V)
