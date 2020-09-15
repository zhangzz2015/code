# In-place convert a 3-ary tree to a singly linked list only utiizing the "c3" link. In the order of preorder.
## traverse
Following a preorder traversal, we can link the current node to the prev node. Thus, we need to maintain a global variable to record the  previous node.<br>
time: O(n)<br>
space: O(height)
## pure recursion
- We can flatten left and right subtrees -> subproblems
- connect them together following post/pre/in order -> induction rule

                        1
                    /   |   \
                   2    3    4
                  /|    |
                 5 6    7
                       /|\
                      8 9 1
               
          preorder:     
                1
            /   |  \       root    c1          c2          c3
           2    3   4   ->  1->|2->5->6->|3->7->8->9->10->|4
           |    |
           5    7
           |    |
           6    8
                |
                9
                |
                10

pure recursion: order is postorder<br>
To connect we need the tail of the previous sublist and the head of the next sublist, and this is preorder so the child is the head when we are at a current node. But in other orders like inorder we need to return both the head and tail in the recursion.<br>
We return the tail in this case.<br>
time: O(n)<br>
space: O(height)
