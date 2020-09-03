## sliding window
We can use a sliding window to inorder traverse the tree, and that make the problem into finding the k closest values in the sorted array. Maintain the deque: every time we check a two head of the deque and poll the larger one.<br>
time: O(n) - n is the number of nodes in the tree.<br>
space: O(k)
## iterator
We can use two iterator. One starting at the largest smaller and the smalllest larger element. Which is closer to the target and add to the result.<br>
time: O(logn + k)<br>
space: O(n) - iterator stack or call stack space