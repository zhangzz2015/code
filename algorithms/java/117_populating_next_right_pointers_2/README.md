## Solution
We can use a curNode to iterate the node in the nodes level by level from left to right. Also we need to record a prevNode which we can link prevNode.next to curNode. Also, we need a nextLevelHead to record the head of the next level.<br>
Because this is not a complete tree, every time we generate a child we need to check whether that node exists.<br>
n is the number of nodes<br>
time: O(n)<br>
space: O(1)