# Binary Tree Top View/Bottom View
If node n is ar column x, n.left is at column x - 1, n.right is at column x + 1.
    
                   5
               /      \
              1        9
               \     /   \
                3    8   11
               /
              2
    top view [1, 5, 9, 11]
    bottom view [2, 3(8), 9, 11]
For each column, find the node with smallest level:<br>
1. This is a traversal problem.
2. We need to know additional about the information of the column in each node.
3. We can use BFS to traverse the tree, in that case we can know the first element in each column is the top view because we are traversing in the order of top to bottom.<br>
Time: O(n) - n is the number of nodes in the tree<br>
Space: O(n) we need a map to store the top view of each column and a queue to store traversing nodes for BFS.
