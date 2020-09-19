# Given the levelorder traversal sequence of a binary search tree, construct the original tree.
Assumption:
1. The given sequence is not null
2. There are no duplicate keys in the bst
## recursion
We can use recursion to solve this problem.<br>
1. We need to use levelorder to know the root. Each element in the levelorder is a root.
2. Create two lists for left subtree and right substree of their levelorder

        best case:
                      root(n)
            left(n/2)        right(n/2)
          LL(n/4) LR(n/4)    ....
        time: O(nlogn)
        space: n + n/2 + n/4 + ... = O(n)

        worst case:
                    root(n)
            left(n-1)      right(0)
          LL(n-2)  LR(0) ...
        time: O(n^2) -> n + (n - 1) + (n -2) + ... + 1
        space: O(n^2)
