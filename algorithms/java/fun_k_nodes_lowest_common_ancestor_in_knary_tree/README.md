# Given m nodes in an k-nary tree, find their lowest common ancestor.
Assume m >= 2 and m nodes are guaranteed to be in the k-nary tree.<br>
The logic of the recursion is still the same:
- return the lca of all nodes in the knary tree
- if more than two nodes in the subtree -> return lca
- only one of the nodes in the subtree -> return the node itself
- none of a, b in the subtree -> return null

time: O(n)<br>
space: O(height)

