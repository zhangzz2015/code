# Given a list of vertices return the topological order of the vertices.
Assuming this is an directed graph.<br>
If there is cycle in the graph then throw an exception or return an empty list.

## dfs
A task can be executed only when all its dependencies are cleared.<br>
For a graph as edge direction with n1 -> n2 meaning that n1 depends on n2 (after n2 complete, then we can run n1)<br>
We mark a node visited only when all vertices reachable from that node are marked visited.<br>
And we add VISITING state to the node, we can detect whether there is circle or not at the same time.

time: O(E + V)<br>
space: O(V)
