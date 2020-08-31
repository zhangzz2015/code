# Longest increasing path following parent -> child direction in binary tree
             9
          /     \
         2       3
       /   \    /  \  
      -4    5  -3  -7 
     /  \   / \
    6    1 6   1
          / \ 
         3   4
    return 3, the longest increasing path is [2, 5, 6]

## backtracking
When we are using backtracking we are tracking on a path to see the longest increasing path. That transforms to a longest increasing subarray in the traversing path.<br>
For all the paths:<br>
- for each node, finding the longest increasing path ending at the cur node.

The information we need to pass down is:
- prevLongest
- prevNodeValue

time: O(n)<br>
space: O(height)
## pure recursion
For all paths:
- for each node, finding the longest increasing path **starting at cur node**.

Returning value: longest increasing path starting from root(including root)

time: O(n)<br>
space: O(height)

**LinkedList -> Binary Tree -> n-ary Tree -> DAG -> directed graph possibly with cycle || undirected graph**

### Follow up 1: n-ary tree

    int longest = 1;
    for (TreeNode child : root.children) {
        int subLongest = longest(child);
        if (root.val < child.val) longest = Math.max(longest, subLongest + 1);
    }
**Can apply both backtracking and pure recursion.**

### Follow up 2: DAG(directed acyclic graph)

              9
           /     \
          2   ->  3
         / \
       -4   5
assumption: all the nodes are reachable form hte root node
**Can apply both backtracking and pure recursion.**<br>
backtracking: find all the paths starting from root, following the recursion tree.

    public int longest(GraphNode cur, int prevValue, int prevLongest) {
        if (cur == null) return 0;
        prevLongest = (cur.val > prevValue) ? prevLongest + 1 : 1;
        int longest = prevLongest;
        for (GraphNode nei : cur.neightbors) {
            longest = Math.max(longest, longest(nei, cur,val, prevLongest));
        }
        return longest;
    }
time: O(# of paths) worst case<br>
branching factor: k<br>
O(k^|V|)<br>
There is no chance you can do any optimization on time complexity. Especially we cannot use memoization for backtracking if the return value contains inforamtion related to the path from root to the current node.<br>
pure recursion:<br>
return value: starting from the current node, what is the longest increasing path. No matter how many times we apply recursion on the node, the return value is exactly the same.
- return value only related to the subproblem starting from the node
- it is not related to how to reach the node

We can apply memoization and ensure each subproblem is calculated only once. Thus the time can be optimized to **O(|V| + |E|)**.

### Follow up 3: Directed Graph with Possible Cycle
backtracking: yes (record path visited); pure recursion: yes
### Follow up 4: Undirected Graph
backtracking: yes (record path visited); pure recursion: yes