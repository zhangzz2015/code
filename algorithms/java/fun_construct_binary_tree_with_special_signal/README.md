# Given an array with # to represent null node of pre/in/post order, construct the tree.
Using special signal we can allow duplicates in the array.<br>
We can construct a unique tree using a special signal because that this is a full tree when we note all the null node in the tree.<br>
If it is a full tree then we can construct that tree with the duplicate nodes in it.
## recursion
We just follow pre/in/post order to construct the tree. When we meet a special character regard that as null.<br>
time: O(n)<br>
space: O(height)
