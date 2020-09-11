## solution
Because this is a binary tree, if the root is larger than one node and smaller than the other node than that node is the lca.<br>
There are three case:
1. if both of the nodes are smaller than the root: root = root.left
2. if both of the nodes are larger than the root: root = root.right
3. if one node is smaller and one node is larger: return root

time: O(height)<br>
space: O(1)
