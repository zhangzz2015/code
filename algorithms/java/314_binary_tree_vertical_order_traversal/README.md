## BFS
We can use BFS to traverse the tree, and also we need to keep track of the column information. In that case all nodes are traversed in level order, thus when we meet a column we can store that into the corresponding list. Becasue we also want to maintain the order of vertical views from left to right which means columns from small to large, we can use a treemap to store all column -> vertical view list<br>
Time: O(nlogn) - n is the number of nodes in the tree<br>
Space: O(n + n) - we need queue for store nodes that will be generated; we also need to use a treemap to store all the node in list.

