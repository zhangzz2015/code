## backtracking
for each of the character in the character board as the starting node, we do backtracking.<br>
Suppose the word length is n, then we have n levels<br>
For each level we search for four neighbor directions to see whether there is the next character of the word.

time: O(3^word)<br>
space: O(m * n + word) mark visited + call stack
