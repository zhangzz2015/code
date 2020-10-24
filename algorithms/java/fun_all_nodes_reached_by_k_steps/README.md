# Given an initial node, finding all the nodes can be reached by moving smaller or equal than k steps. (for each step we move to one of the neighbor nodes).
k steps => kth level<br>
Finding all the nodes reachable within k levels<br>
Finding all the nodes with the shortest path <= k to the initial node.<br>
We can do a BFS -> mark visited and terminate at level k.

time: O(E + V)<br>
space: O(V)
