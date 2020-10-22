We need to build the graph first. Because we want to know the lexico order to in the input. We just need to compare the each word with the word next to it. Compare the characters in the two words, and if find a different that means the different word in the next word is lexicoly larger than the current word.<br>
We can regrad the lexico order as a topological order. The smaller characters are the dependency of the next character.<br>
Then after building the graph we can traverse the graph and find the topological order.<br>
And we can choose dfs and bfs to traverse the graph and find the topological order.
## dfs
time: O(every letter of the words + E + V) - to build the graph we need to check every letter of every word<br>
space: O(E + V)
## bfs
time: O(every letter of the words + E + V)<br>
space: O(E + V)
