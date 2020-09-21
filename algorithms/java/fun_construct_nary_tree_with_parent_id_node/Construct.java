class Construct {
    
    static class Pair {
        int nodeId;
        int parentId;
    }

    static class TreeNode {
        int id;
        List<TreeNode> children;
    }

    // recursion
    public TreeNode construct(List<Pair> preorder) {
        if (preorder == null || preorder.isEmpty()) return null;
        return construct(new ArrayDeque<>(preorder));
    }
    private TreeNode construct(Deque<Pair> preorder) {
        TreeNode root = new TreeNode(preorder.pollFirst().nodeId);
        while (!preorder.isEmpty() && preorder.peekFirst().parentId == root.id) {
            root.children.add(construct(preorder));
        }
        return root;
    }

    // iterative
   public TreeNode construct1(List<Pair> preorder) {
        if (preprder == null || preorder.isEmpty()) return null;
        return construct1(new ArrayDeque<>(preorder));
   }
   private TreeNode construct1(Deque<Pair> preorder) {
        Deque<TreeNode> stack = new ArrayDeque<>(); // rightmost path
        TreeNode root = new TreeNode(preorder.pollFirst().nodeId);
        stack.push(root);
        for (Pair pair : pre) {
            while (stack.top().id != pair.parentId) {
                stack.pop(); // the treenode poped out means this subtree finished construct
            }
            TreeNode cur = new TreeNode(pair.nodeId);
            stack.top().children.add(cur);
            stack.push(cur);
        }
        return root;
   }
}
