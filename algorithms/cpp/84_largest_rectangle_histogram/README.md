## mono stack
When the height at the end of the stack is larger than the current that means we can use this stack top as the leftmost and its height as the rectangle height. And we can continue use the next top. Thus, the elements used in the rectangle are [stack.top(), cur).

time: O(n)<br>
space: O(n)
