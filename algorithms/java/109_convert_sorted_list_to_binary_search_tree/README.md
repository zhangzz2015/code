## convert the sorted list to sorted array first, then solve the similar problem.
time: O(n)<br>
space: O(n)
## recursion with find mid
Finding the mid need O(n) time in the liked list, and doing recursion with the left subtree and the right subtree.<br>
time: O(nlogn)<br>
space: O(logn)
## recursion with O(n)
We need to already traversed all the nodes and constructed them before the root node in the list, thus we know the mid element without extratime to find.<br>
Thus the recursion need to do both construct and inorder traverse.<br>
To identify the root, know the boundary, and we use a global pointer to inorder traverse the linked list and pointer to the root.<br>
time: O(n)<br>
space: O(logn)
