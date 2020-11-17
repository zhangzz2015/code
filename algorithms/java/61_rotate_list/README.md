## solution
For rotatign the list, we want to find the new head and append all the nodes before the newhead to the end fo the node.<br>
1. we need to find the prev node of the head. We need to know the length of the list first and we need to move (length - k % length) - 1 from the head node.
2. break and append

time: O(n + (length - k % length) - 1)<br>
space: O(1)
