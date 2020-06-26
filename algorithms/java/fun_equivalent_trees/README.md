## Solution
How can we define the same expression?<br>
After resolve the parenthesis they are the same.<br>
Can the elements change the order? NO<br>
If we want to compare the expression one by one then we just need to iterate through all the numbers or operators one by one and compare them.<br>
If we traverse the expression tree with inorder traversal then we are going through the expression from left to right and compare them one by one.<br>

if n is the number of nodes<br>
Time: O(n)    because we need to go through all the nodes once and compare them.<br>
Space: O(height)  if we are using an iterator we need to use a stack to store the nodes and the most number of nodes that can be stored into the stack would be the number of height.
