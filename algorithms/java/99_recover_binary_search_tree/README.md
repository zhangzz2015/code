## inorder traversal
If we are doing inorder traversal, then if the node is reversed with the previous node we know that this node is the node need to be recovered.<br>
[1, 4, 5, 11, 8, 9, 7, 15, 17, 20, 25]<br>
need to swap 11 and 7<br>
need to deal with a kind of corner case [1, 4, 5, 11, 7, 15, 17, 20, 25]<br>
Both element is in the same pair.<br>

1. For the first node, we need to find the first to be the prev in the pair
2. For the second node, we need to find the last to be the latter in the pair

time: O(n)<br>
space: O(height)
