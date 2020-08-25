## Inorder Traversal in Binary Tree
There are three ways to traversal in a binary tree.<br>
1. recursive<br>
    - **pros:** simple, elegant
    - **cons:** call stack space! not in heap / stack overflow
2. stack<br>
    - **pros:** use explicite stack on heap which has a lower chance to meet stack overflow
    - **cons:** more code
3. parent pointer<br>
    - **pros:** not need to worry about stack space
    - **cons:** need another pointer, more condition to consider
    - traverse the current node, what is the next:
        - we don't need to look at the leftsubtree at all!!
        - only need to look at the **right subtree**<br>
            current.right != null:
                firstNode(current.right)<br>
            current.right == null:
                through the parent pointer, go up find the first node, that the leftsubtree is finished

Both 1 and 2 need<br>
Time: O(n) - n is the number of nodes<br>
Space: O(height) - height of the binary tree<br>
For 3<br>
Time: O(n) - n is the number of nodes<br>
Space: O(1)