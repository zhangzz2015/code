This problem is minimum spanning tree problem. We can use Kruskal or Prim to solve this problem.

## Kruskal
We first sort all the edges by weitght.<br>
From the smallest weight edge, if both start and end of the edge are not in the same group then we union them. When we used n - 1 edges we complete building the minimum spanning tree.<br>
Thus, we need a union find data structure.

time: O(|E|log|E|) -> O(n^2logn^2)<br>
space: O(|E|) -> O(n^2)
## Prim
From one starting point, we pick the smallest cost edge starting from all the nodes that is already expand to the minimum spanning tree we pick the smallest cost edge and add the endign node to the minimum spanning tree.<br>
If using adjacency matrix we can reduce the time to |V|^2, otherwise it would still be ElogV. If the graph is a dense graph Prim would be better comparing to Kruskal.

time: O(|V|^2) using adjacency matrix<br>
space: O(|V|) using adjacency matrix
