# Divide a given binary search tree into two separate binary search trees T1 and T2 using a given target as pivot, such that T1 contains all the nodes \<= pivot, T2 contains all the nodes > pivot.

## Go down the path of searching target.
1. If the root of the subtree is smaller than the target, we add the root and its left subtree to T1.
2. If the root of the subtree is larger than the target, we add the root and its right subtree to T2.

time: O(logn)<br>
space: O(1)
## pure recursion
return: the smaller subtree and larger subtree<br>
induction rule:
- root <= pivot:
    - root.left no need to change
    - recursion(root.right) -> (T1, T2); root.right = T1; return p(root,T2)
- root > pivot:
    - root.right no need to change
    - recursion(root.left) -> (T1, T2); root.left = T2; return (T1, root)

time: O(height);
space: O(height);
