# Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

                     5
                  /    \
                 1      7
                / \    /
               3   4  2
               level order: [5, 1, 7, 3, 4, 2]
               in order: [3, 1, 4, 5, 2, 7]

Assumption:
1. The given sequences are not null and they have the same length
2. There are no duplicate keys in the binary tree
## recursion
1. We need to use levelorder to know the root, and we also need the left subtree levelorder and the right subtree levelorder, and they are not continuos.
2. Create two lists for left subtree and right subtree of their levelorder.

        best case:     
                            root(n)
                left(n/2)             right(n/2)
            LL(n/4)   LR(n/4) ....
        time: O(nlogn)
        space; n + n/2 + n/4 + ... = O(n)

        worst case:
                            root(n)             n
                left(n-1)             right(0)  n-1
            LL(n-2)   LR(0) ....                n-2
                 ...                            ...
        time: O(n^2)
        space: O(n^2)
