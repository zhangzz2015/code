## backtracking + trie
For each of the word we can search the whole graph using each node as the starting node to do a backtracking, but this will be very time consuming.<br>
We can build a trie with all the strings that are given.

time: O(all letters in words + (m * n * 3)^L)<br>
space: O(all letters in words)
