## Serialize and Deserialize binary tree with node value is String. String to represent delimiter and null node can be appeared as the value of the binary tree.

We can use a special character to note null node in the tree, so we can represent the tree with one order string of the values. Because the node's value is string, all the characters that we are using might be used as value. Thus, we can use an escape character to note when the node's value is the character that we are using.

time: O(n)<br>
space: O(height)
