For an undirected graph to be a tree it must satisfies 2 of the 3 conditions among:
1. no cycle
2. connected
3. |E| = |V| - 1

## 1 + 3
We can traverse the graph to count the edge and build the graph. Traverse the graph to see if there has cycle.

time: O(E + V)<br>
space: O(E + V)

## 2 + 3
We can traverse the graph to count the edge and build the graph. Traverse the graph to see is all the nodes are connected.

time: O(E + V)<br>
space: O(E + V)
