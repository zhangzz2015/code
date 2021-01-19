# Given a BST and a target number, how to find three nodes in the tree such that node1.val + node2.val + node3.val == target.

## serialize
Transfer the bst into a sorted doubly linkedlist, and we treat this as a sorted three sum problem.

time: O(n + n^2)<br>
space: O(height) - for serialize
## iterator
We can also use iterator as the pointers and we treat this as a soerted three sum problem.

time: O(n)<br>
space: O(height)
