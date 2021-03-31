## bfs
From each of the rotten oranges, we can traverse to all the reachable oranges from the start. Each level is a time count.<br>
To check whether all the fresh oranges become rotten, we can first count the number of fresh oranges, when the orange is rotten we decrease the count. When the BFS if finished we can check the number of fresh oranges left.

time: O(|E| + |V|) -> O(4 * m * n + m * n) -> O(m * n)<br>
space: O(|V|) -> O(m + n)
