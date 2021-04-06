## bfs
Starting from the initial state, traverse all the states in bfs order which is one change away from the current state. To mark the states we can turn the board to a string, and use that string to represent the states.

time: O(|E| + |V|) -> O(3 * m * n + m * n)<br>
space: O(m * n)
