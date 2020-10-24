# Two kinds of mark visited of bfs
## mark visited at expansion
time: O(V + E) for each node, expand once -> generate all the edges from this node once.<br>
space: O(E) -> number of times of offer() -> number of time of generates
## mark visited at generate
time: O(V + E) for each node, expand once -> generate all the edges from this node once.<br>
space: O(V) number of times of offer() -> there is no duplicates when offering to the queue
