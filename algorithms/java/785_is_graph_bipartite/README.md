## graph traverse
We can traverse the graph and color the nodes into two colors.<br>
While we are traversing:<br>
- if we encounter a node never visited: we color it to the color different then before.
- if we encounter a node that has been visited: check that if the color is different with the current node.

time: O(|E| + |V|)<br>
space: O(|V|)
