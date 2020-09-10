# Given K nodes in a binary tree, find their lowest common ancestor.
Assume: K >= 2, and the given K nodes are guaranteed to be in the binary tree.<br>
We can still use recursiont to solve the problem.<br>
The recursion logic is still the same: return the lca of all nodes<br>
- if more than two nodes in the subtree -> return lca
- only one of the node in the subtree -> return the nodes itself
- non of the nodes in the subtree -> return null

time: O(n)<br>
space: O(height)
