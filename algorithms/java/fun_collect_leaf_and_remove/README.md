# Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat untill the tree is empty.

	                1
                  /   \
                 2     3
                / \
               4   5
          result: [[4, 5, 3], [2], [1]]
## Solution
We want to group the nodes from the lowest height to the highest height.<br>Here the definition of height is the largest number of nodes from the leaf to the current node.<br>
We can use pure recursion to solve this problem.<br>
input: a root of the tree<br>
output: the height of the curretn node from the leaf<br>
At every node we add the node to the spot corresponding to the height from the leaf.<br>
time: O(n) - n is the number of nodes<br>
space: O(height)
