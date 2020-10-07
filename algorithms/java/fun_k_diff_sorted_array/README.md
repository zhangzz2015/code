# k-diff sorted array(each of the elements has at most k as distance to its sorted position), How to sort it efficiently? Less than O(nlogn)
Assumption:<br>
1. there are duplicates
2. k > 0, k <= size - 1

## solution
We cam find the elements from the smallest to the largest.<br>
We can maintain all the elements possible for the current smallest element that we are traversing.<br>
in each round: we pollMin() to the current position, and offer the next.<br>
Thus, we can use a minHeap to store the candidates for the current smallest element in the array.<br>

time: O(nlogk)<br>
space: O(k)
