## brutal force
We can create two dummy head of smaller part and larger part. Then we go through the list and chain the smaller nodes to the smaller part and chain the larger nodes to the larger part.<br>
Notice we need to chain the larger part to the end of the smaller part, and we need to mark next node of the last node to null.

time: O(n)<br>
space: O(1)
