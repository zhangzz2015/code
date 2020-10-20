# Determine if a graph is a tree.
## undirected graph
If the undirected graph is a tree, then it satisfies the following 3 properties:
1. no cycle
2. E = V - 1
3. connected<br>
if the undirected graph is tree => 1, 2, 3<br>
1, 2 => the undirected graph is tree => 3
1, 3 => the undirected graph is tree => 2
2, 3 => the undirected graph is tree => 1

## directed graph
Cannot use the property above!!!<br>
1. find the root, the only node has indgree of 0.
	- traverse the whole graph -> traverse each of the edges(u, v), for each edge v.indegree++;
	- O(V + E)
2. from the root, run a dfs/bfs, mark visited for the node when first time visiting. Traverse the graph to see if there is any node visited multiple times.
	- O(V + E)
