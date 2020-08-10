## Reverse a Doubly Linked List
For every node we reverse the next and prev of each node. While doing this swap we can record the next node for the sake of swap the two pointers.<br>
We can use a prev node the record the previous node and that would be the return of that node.<br>
We can also don't use that prev node, and check every time if the next node is null. If the next node is null then we can return the current node.<br>
time: O(n)<br>
space: O(1)