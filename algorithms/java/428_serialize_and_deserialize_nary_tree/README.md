## recursion
We need to know the root and when the subtree ends.<br>
We can use [a[b][c][d]] to represent a general tree. This is like in HTML we use <div> </div> or JSON {} to note a part.<br>
The first node in a part is the root of the subtree. We will construct every node before the note of end.<br>
time: O(n)<br>
space: O(height)
