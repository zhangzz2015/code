## dfs
For this problem, the problem is actually asking us to find the nodes that are not in the cycle. From this node all the path should be leading to a terminal node.<br>
For each node it has three states:
1. unvisited -> null
2. visited but unsafe
3. visited but safe

Starting from each node, we can traverse the graph with dfs:
- if all the neighbors are safe them this node is safe, otherwise this node is unsafe.

time: O(E + V)<br>
space: O(V)
