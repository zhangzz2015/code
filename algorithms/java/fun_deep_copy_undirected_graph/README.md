# Deep copy an undirected graph. (There could be cycles in the original graph)
## solution
We need to copy all the nodes and all the edges.<br>
1. iterate all nodes in graph
2. when we iterate each node, we need to copy the node and copy all the outgoing edges from the current node.<br>
We can use a map to map the origin vertex to the copied vertex.<br>

time: O(E + V)<br>
space: O(V)
