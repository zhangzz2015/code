class Construct {
    // 2. do both in recursion
    int preIndex = 0;
    int postIndex = 0;
    public TreeNode construct(String[] pre, String[] post) {
        TreeNode root = new TreeNode(pre[preIndex]);
        preIndex++;
        // when the next element in post order is root itself, we know the current tree is complete
        while (!post[posIndex].equals(root.val)) {
            root.children.add(construct(pre, post));
        }
        postIndex++;
        return root;
    }
}
