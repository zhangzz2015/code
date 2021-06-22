## linear scan
Because the array is sorted, the same elements are grouped together.<br>
For each of the element, we compare this element's value to the next node's value. If they are the same then we need to chain the current node to the next next node, and delete the same value node.

time: O(n)<br>
space: O(1)
