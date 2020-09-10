# Given two nodes in a k-nary tree, find their lowest common ancestor.
Assume all nodes are guaranteed to be in the k-nary tree.<br>
We can use the same recursion logic to solve the problem.<br>
The only difference is the # of subtree branches><br>
- two nodes are in the subtree -> return lca
- one node is in the subtree -> return that node
- none of the node is in the subtree

time: O(n)<br>
space: O(height)
