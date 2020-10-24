## Mark visited 1
Starting from a given node, traverse all the reachable nodes using dpth first heuristic and each node is only visited once.<br>
**Mark the node as visited when first time entering the node.**

time: O(V + E) every node will be visited once O(V) and every edge will only be generated once.<br>
space: O(V)
## Mark visited 2
Mark visited after all its descendants.<br>
We need additional state "visiting" to deal with a special marker of the nodes on the current dfs path to avoid duplicately visiting nodes.<br>
**Mark the nodes as visitin when first time entering the node, Mark the node as visited when all the neighbors are visited.**

time: O(E + V)<br>
space: O(V)
## Mark visited 3
Care about the pathes, instead of the vertex is reachable in this case.<br>
Find all paths from the start node, on the path there is no duplicate vertices.<br>
**only mark for the nodes on the current dfs path, avoiding cycle on the dfs path**

time: O(branch^V)<br>
space: O(V)

