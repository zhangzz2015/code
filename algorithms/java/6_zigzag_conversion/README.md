## solution
For this kind of zigzag format, we find that there is a cycle in this pattern. The cycle is the row * 2 - 2.<br>
For each of the elements in the pattern we add all the same position in the pattern.<br>
If the character is not in the first and the last row, we need to consider not only the character in the next pattern but also in the same pattern.

time: O(n)<br>
space: O(1)
