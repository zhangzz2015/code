## bfs
for every Cell of 1 we want to know the closest 0 distance.<br>
for this graph:
- vertex: all the [i, j] in the matrix
- edge: for directions with weight 1

for every 1 find the distance to any shortest 0.<br>
Because this is a udirected graph we can transfer the problem into from any of the 0 to all the 1. Thus we can use kbfs.

time: O(V + E) -> O(n^2 + 3n^2)<br>
space: O(V) -> O(n^2)
