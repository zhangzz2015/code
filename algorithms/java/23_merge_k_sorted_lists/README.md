## solution
We want to build the sorted list from the smallest up till the point to the largest of all nodes in all the lists.<br>
Thus we can use a minHeap to keep track of the smallest nodes in of the list if they still have nodes left.<br>

time: O(nlogk) n is the number of nodes in all the list k is the number of lists.<br>
space: O(k)
