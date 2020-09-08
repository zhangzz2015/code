# Quick Select
Using pivot to partition the array, but we only go the one part where the kth element is bwtween the two parts aside the pivot. There are two way of implementation to this algorithm: 1. recursion 2. iterative. This recursion is a tail recursion, so we can transfer that into the iterative way.<br>
time: O(n) - average  O(n^2) - worst case<br>
space: O(1)
## recursion (need more space in call stack)
need to assume k is valid: >= 1, <= array.length
## iterative
a little bit like binary search.
