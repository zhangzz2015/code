## Heap Sort
Heap sort is the in-place comparison based sorting algorithm naturally.<br>
e.g. {2, 4, 3, 1}
**Step 1**: heapify the array to a max_heap {4, 2, 3, 1} - O(n)<br>
**Step 2**: poll() on the maxHeap, swap 4 with rightmost position -> {1, 2, 3, | 4} - O(logn)<br>
**Step 3**: precolateDown(1) -> {3, 2, 1, | 4} - O(logn)<br>
**repeat step 2 and step 3 (n - 1) times**
This algorithm is guaranteed to have:<br>
time: O(nlogn)<br>
space: O(1)