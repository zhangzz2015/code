# Bi-Directional BFS
Starting from both init and goal node, simultaneously do bfs, util the two bfs explored areas reach each other.

Using this methods, we can optimize the time from O(b^l) to O(2 * b^(l/2)) = O(b^(l/2). b is the branching factor and l is the level between init and goal.

for the algorithm:
- each round, do 1 level bfs from start, and 1 level bfs from goal.
	- check if there is any overlapped element from the explored area from start and explored area from goal
	- when generate new elements from start: check if it is explored from goal
	- when generate new elements from goal: check if it is explored from start
- termination condition: until we find the first overlap - from start and goal, both do l/2 levels.
	- if there is a shortest path from A to B, the overlapping point should be at the middle of the shortest path

