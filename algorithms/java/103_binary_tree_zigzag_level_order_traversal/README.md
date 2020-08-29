## BFS
Because this is level order traversal, the most intuitive way of thinking is use BFS to traverse the tree level by level. We also need to maintain a level to know which way we want to go. Thus we can use a deque every time when we expand the node we are the choose from left of the deque or the right of the deque according to the level. But when we generate the children we need to still maintain the originial order of the tree in the deque.<br>
time: O(n) - n is the number of nodes in the tree.<br>
space: O(n)

## DFS
We can still use dfs to traverse the tree. Because the level order is the determined by the level, we need to maintain the level of each node while we are traversing through the tree. We can use preorder traversel, because preorder will start from the lowest level to the highest level. But in the result list of each level, if the level is even number we add at the end of the list, if the level is odd number we add at the first of the list.<br>
time: O(n) - n is the number of the nodes in the tree<br>
space: O(height)