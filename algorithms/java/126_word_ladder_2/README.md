## bfs
We can use bfs to traverse the graph and build each words prev in a hashmap. Then starting from the endWord we use a dfs to traverse all the possible paths and find out all the path.<br>

time: O(m * n + n + n) - m is the length of each word. n is the numebr of the words<br>
space: O(n);
