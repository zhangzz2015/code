## Level by level traverse the binary tree<br>Traverse order: for each level, from outside to inside.
Since we are traversing the tree level by level so we can use a BFS to traverse the tree.<br>
From the output of each level we can see that for the left part of the whole tree we go in the order of first left child and then right child. For the right part of the whole tree we go in the order of first right child and then left child.<br>
For implementing this to differentiate the left part of the whole tree and right part of the whole tree, we can use one queue for the left part and another queue for the right part.<br>
n is the number of nodes<br>
time: O(E + V) -> O(n)<br>
space: O(v) -> O(n)

