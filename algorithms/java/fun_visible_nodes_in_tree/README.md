# Binary tree, a node is visible only if its value is the largest one on the path from root to itself, find all the visible nodes.

                2
             /     \
            7       1
           / \     / \
          6   5   3   4
    visible nodes: [2,7,3,4]
Because we want the information from the root to each node, we can use backtracking. The information we pass down determines if current node is visibe. That is if the current cur value is larger than the max value from root to the path of current node except itself.<br>
time: O(n) - n is the number of nodes in the tree.<br>
space: O(height)