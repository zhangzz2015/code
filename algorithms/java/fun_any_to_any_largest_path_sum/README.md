# 人字形 any to any - largest path sum
We can only use recursoin to solve this problem. Backtracking do not work because we also need information from other paths.<br>
For each node: we want to find the largest any to any path using this node as the vertex.<br>
The return value is the maximum path sum starting from root(including root) up down path.