## DFS
We want to traverse the whole tree only once, and get all hte answer.<br>
We can use preorder dfs to traverse the tree, but to define the leftmost and rightmost tree we need to use two boolean variable to know that whether the node is on the leftmost path or the rightmost path.<br>
If go left:<br>
1. For leftMost: Next level leftMost is still same with the current leftMost
2. For rightMost: Next level rightMost is true only if current level node is still the rightmost node and the right child of the current node is null 
If go right:<br>
1. For leftMost: next level leftMost is true only if current level node is still the leftmost node and the left child of the current node is null.
2. For rightMost: Next level rightMost is still same with the current rightMost


    1. leftmost path: 
        - dfs, preorder, left -> right<br>
        1.1: leftMost == true: already on the left most path<br>
        1.2: root.left == null && root.right == null: reach a leave<br>
    2. rightmost path:
        - dfs, postorder, left -> right<br>
        rightMost && (root.left != null || root.right != null) is the right most path exclude the leaf.
    3. all the leaves left to right:
        - dfs, pre/post/in, left -> right<br>
Time: O(n) - n is the number of nodes in the tree.
Space: O(height)