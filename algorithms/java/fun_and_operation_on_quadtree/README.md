# Assume some binary (each pixal is either or white) images, having the same width, and the length is power of 2. Present it by quadtree: divide the image into quarters, each quarter can be all black, all the white or mixed, only need to subdivide the mixed ones recursively.

    +-------+---+---+               
    |       | F | F |    
    |   T   +---+---+                     root
    |       | T | T |               /   /     \      \
    +---+---+---+---+   =>         T    ()     ()     F
    | F | T |       |                  /\\\    /\\\  
    +---+---+   F   |                  FFTT    FTFT
    | F | T |       |
    +---+---+-------+

If two pixals are black then it is black, otherwise it is white. Regard black as 1 and white as 0, this is AND operation.<br>
For the node in this tree, there are two kinds of nodes, and the color inforamtion exists only if it is a leaf node. Thus we need to design the node class to represent the tree.<br>

We can use recursion to solve this problem.<br>
1. recursion definition:
    - input: r1, r2
    - problem: AND
    - return: after the AND operation on the two rees, what is the root node of the final result tree.
2. induction rule:
    - r1 is leaf, r2 is leaf -> perform AND operation
    - one of r1, r2 is leaf and the other is non-leaf
        - leaf node == 0: return this leaf node
        - leaf node == 1: return the non-leaf node
    - both are non-leaf