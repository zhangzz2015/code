# Get the sum of all the leaf nodes for an n-ary tree, **space complexity should be O(1)**. Design the class to represent the tree yourself.

                3
          /    \   \   \
         2      1   4   9
               / \    \
              5   6    8
                      / \ \ \
                     0   3 1 2
This means we need to traverse the tree in O(1) space, but using the regular tree class both bfs and dfs can not do that. We can add a parent pointer to traverse the tree. Because when we traverse the n-ary tree it is hard to know which is the next child of the n-ary tree. We also need a reverse index map to help us know the index of the children to know the next child.

    class TreeNode {
        int val;
        List<TreeNode> children;
        Map<TreeNode, integer> reverseIndex;
        TreeNode parent;
    }

    TreeNode firstNode(TreeNode root) {
        return root;
    }
    TreeNode nextNode(TreeNode cur) {
        if (!cur.children.isEmpty()) return firstNode(cur.children.get(0));
        while (cur.parent != null && cur is cur.parent's last children) {
            cur = cur.parent;
        }
        return cur.parent's next children;
    }
Thus, we can change the tree node class for us easier to know which is the next child for a parent. That means we can add a pointer to between the children.

    class TreeNode {
        TreeNode parent;
        TreeNode eldestChild;
        TreeNode nextSibling;
    }

    the tree become：

                3
            /
           2 -> 1 -> 4 -> 9
                /      \ 
               5 -> 6   8
                       /
                      0 -> 3 -> 1 -> 2