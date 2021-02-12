## recursion
- input: subtree root we want to check if this is full tree
- output: whether this subtree is full tree or not
- induction rule:
	- base case: is leaf return true
	- if one child is null and the other is not return false
	- both of the left and right shoud be true -> return true

time: O(n)<br>
space: O(height)
