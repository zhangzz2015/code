# For a binary tree with only 0/1, remove all zero subtree and return the new tree.

                    1
                  /    \
                 1      0
                / \    / \
               1  '0' 1  '0'
              /   / \      \
            '0' '0' '0'    '0'
            
            '0' means we need to delete

Definition of recursion:<br>

1. input: TreeNode root -> tree
2. problem: change the subtree structure, remove all-zero subtrees
3. return: after changing the structure, what is the root of the subtree
4. induction rule: 
    - root == 1, return root
    - root == 0, 
        - root.left || root.right != null, return root
        - esle return null
    
    
