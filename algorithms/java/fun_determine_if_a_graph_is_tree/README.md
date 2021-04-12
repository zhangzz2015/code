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

See [Graph Valid Tree](./../261_graph_valid_tree/README.md) 

## directed graph
Cannot use the property above!!!<br>
1. find the root, the only node has indgree of 0, and check all other in-degree == 1:
	- traverse the whole graph -> traverse each of the edges(u, v), for each edge v.indegree++;
	- O(V + E)

2. Check all nodes can be reached from the only root
	- O(V + E)

time: O(|E| + |V|)<br>
space: O(|V|)

	After step 1 there is a counter example: one cycle and one tree
	       1  <        4
	    /      |     /   \ 
	    > 2 -> 3    5     6