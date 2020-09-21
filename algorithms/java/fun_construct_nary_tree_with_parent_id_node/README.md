# Given a list of pairs(each pair contains two ids - the nodeID, and parentID) as the preorder traversal sequence.(root node has parentID as -1)<br> Assuming each node in the tree has a uniqueID >= 0.<br> Assume the input list is valid, construct the tree.

                3
              /  \
             1    2
                 / \ \
                4   5 6
        <3,-1>, <1,3>, <2,3>, <4,2>, <5,2>, <6,2>

## recursion
We can use recursion to solve the problem.
- find the root of the subtree -> preorder first element
- identify the subtree's boundary -> when the following elements' parent is not the current node then the current subtree ends.
## Iterative
1. record the rightmost dfs path
2. the next preorder traversing node's parent must be one of the nodes on the rightmost dfs path.<br>

time: O(n)<br>
space: O(height)
