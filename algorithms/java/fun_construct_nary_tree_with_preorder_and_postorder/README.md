# Construct unique general n-ary tree with preorder an postorder.
Assume: no duplicate values.<br>
Because we do not distinguish the left/right in the n-ary tree. All child nodes are stored in a list. There is no difference between the nodes.<br>
We want to know whether every step of constructing is definite.

                        A
                  /  /      \  \
                 B   C       D  E 
                /|\   \     / \
               F G H   I   J   K
            
            preorder:   A | BFGH | CI | DJK | E 
            postorder:      FGHB | IC | JKD | E | A

## recursion
- find the root: root is the first node in the preorder
- boundary of the subtree: for each root of the subtree, find the corresponding position in postorder, then we know the size of the subtree.
## do both in recursion
- preorder construct the tree
- postorder traversal

time: O(n)<br>
space: O(height)


