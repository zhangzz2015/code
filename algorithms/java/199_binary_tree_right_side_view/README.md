# Binary Tree Right Side View
We want to traverse all the node and find the right most node for each level, so we can use DFS or BFS to traverse the whole tree.
## DFS
When we use DFS we need to know which level are we on, thus we use a parameter in the input to count the level. Because we want the right side view if we use preorder traversal with right subtree before the left subtree then every time the first node in that level is the right view we want.<br>
Time: O(n) - n is the number of nodes in the tree.<br>
Space: O(height) - height of the tree, using call stack
## BFS
When we use BFS at every level if we are generating the node from left to right then we want the last node of each level. If we generate the node from right to left then we want the first node of each level.<br>
Time: O(n) - n is the number of nodes in the tree<br>
Space: O(n) - using a queue to store the nodes waiting to be generated at most n nodes