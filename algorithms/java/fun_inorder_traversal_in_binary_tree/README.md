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

Both 1 and 2 need<br>
Time: O(n) - n is the number of nodes<br>
Space: O(height) - height of the binary tree<br>
For 3<br>
Time: O(n) - n is the number of nodes<br>
Space: O(1)