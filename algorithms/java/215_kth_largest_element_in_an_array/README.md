## use size k minHeap
Go through the array once and maintain a size k minHeap, and return the peekwhen finished.<br>
time: O(nlogk)<br>
space: O(k)
## quickselect
Fist choose a pivot, and do a partition in the array and see whether the pivot index. If the index == k then that is the answer, if the index < k, we doquickselect in the right part, if the index > k, we do quickselect in the left part.<br>
time: O(n) - average  O(n^2) - worst case<br>
space: O(1)
