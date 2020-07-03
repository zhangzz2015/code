## Populate next pointers
<pre>
class Node {
    List<Node> children;
    Node next = null;
}
            1(cur)
          /     \      \ 
         2  ->   3  ->  4 -> null
        /         \
       4   ->      5  -> null
</pre>

### Solution 1
We can traverse the tree with bfs, for each node we need to point the next pointer to the next node on the same level.<br>
So we need to track the level while doing bfs.<br>
I think for bfs we can maintain a queue to do the bfs. Because we want to track the level of the tree, for each level we want to record the size of the current queue which means the number of nodes in the current level.<br>
time: O(V + E) -> O(n)<br>
space: O(E) -> O(n)
### Solution 2
We can optimize the space to O(1), we only need to record the next level head node, the current node, and previous node.