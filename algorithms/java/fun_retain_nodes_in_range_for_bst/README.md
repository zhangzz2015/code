# Retain only the nodes in range of [min, max] for a given BST.
We can use recursion to solve the problem.<br>
1. recursion
    - input: root of the subtree, min, max
    - problem/return: after changing the structure, what is the root node
2. induction rule:
    - case 1: keep the root -> min <= root.val <= max -> return root
    - case 2: do not keep the root -> root.val < min || root.val > max

time: O(n)<br>
space: O(height)

## Optimize 1: O(O(logn) + # of nodes in the range)
If the root is already out of range there is no need to search down the direction that is out of range.

## Optimzie 2: O(logn)
We can pass down a information about the range of the current subtree. Thus, we can further do some pruning for the subtree that is already in the range of the required range.