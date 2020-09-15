## recursion
We and recursively construct the tree.<br>
- identify the root
- recursively construct left subtree
- recursively construct right subtree

Each subtree is actually a consecutive part(subarray) of the original array, we can use a leftBound and rightBound to denote each subarray.<br>
Because this is a height balanced binary search tree we can find the root by index which is the mid.
- mid = left + (right - left) / 2 -> root
- [left, mid - 1] -> root.left
- [mid + 1, right] -> root.right

recursion: construct tree with nodes in [left, right]<br>
return: the constructed subtree<br>
For the base case of the recursion we have to know how to find them.<br>

    for 3 elements:  [1]  2  [3]   convert to subproblems with size 1
                          m
    for 2 elemenets: []  1  [2]    convert to subproblems with size 0 and 1
                         m
    for 1 element: []  1  []       convert to subproblems with size 0 and 0
                       m

time: O(n)<br>
space: O(height)
