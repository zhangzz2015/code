# Find the lowest common ancestor of two nodes which may not exist in the tree.
We can use pure recursion to solve this problem.<br>
    
    for each node as the root:
        TreeNode left = lca(root.left)
        TreeNode right = lca(root.right)
        
    We need to know if we return a or b we don't know that if we find two of them and one is in the other's subtree or we only found one.
    Thus, we can add a count meaning the number of targets we found. And when we are returning the value we know that check is the count is equal to 2. Otherwise we need a new ReturnType class which contains the number of nodes found and the lca of them.
time: O(n)<br>
space: O(height)
