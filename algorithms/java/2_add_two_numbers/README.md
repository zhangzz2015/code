##
We can iterate through all the node in two of the linkedlist together.<br>
We only stop when both of the list are being iterated to the end.<br>
while iterating if one list is end then that node is counted as a zero<br>
We need to maintain a carry while calculating.<br>
When all the iterations ended, we need to see whether we still have a caryy or not, and add that to the next of the node.

time: O(m + n) - m and n are the length of the linkedlist seperately<br>
space: O(1)
