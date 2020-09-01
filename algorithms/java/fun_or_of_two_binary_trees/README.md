# Given two binary trees with each node containning a boolean value true/false. Return the result binary tree by applying "OR" operation on them.

        true                      true    
      /       \                  /    \
    fasle     true        OR   false  false
              /   \             /        \
            false  false      false     true

                 true
    =           /     \
              false    true
              /       /     \ 
            false   false   true

## solution
- input: two treenodes representing two subtree
- base case: 
    - treenode1 == null return treenode2
    - treenode2 == null return treenode1
- induction rule: (treenode1, treenode2 != null)
    - put on the left and put on the right