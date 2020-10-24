# Given an initial node, finding all the nodes can be reached by moving exactly k steps. (for each step we move to one of the neighbor nodes)

		n1 -----------> n2-------
		^  \					|
		|   \					|
		|    \--------> n4		|
		|				| \		|
		n3<-------------   \	|
		^ ^				   |	|
		| |----------n5<----	|
		|						|
		|						|
		------------------------|

## bfs
still level by level, but we are not considering the shortest path.<br>
Thus, one node may be visited multiple times.<br>
- for each level, we don't count duplicates.
- one node only need to be visited once at the same level.
- one node can be visited at different levels.

time: O((E + V) * k)<br>
space: O(V)
## k level dfs
time: O(branch^k)<br>
space: O(k)
