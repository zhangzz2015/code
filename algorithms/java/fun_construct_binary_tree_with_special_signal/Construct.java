class Construct {
    private static final String NN = "#";
    private int preIndex = 0;
    public TreeNode constructPre(String[] preorder) {
        if (preorder[preIndex].equals(NN)) {
            preIndex++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(preorder[preIndex]));
        preIndex++;
        root.left = constructPre(preorder);
        root.right = constructPre(preorder);
        return root;
    }

    private int inIndex = 0;
    public TreeNode constructIn(String[] inorder) {
        if (inorder[inIndex].equals(NN)) {
            inIndex++;
            return null;
        }
        TreeNode left = constructIn(inorder);
        TreeNode root = new TreeNode(inorder[inIndex]);
        inIndex++;
        root.left = left;
        root.right = construct(inorder);
        return root;
    }

    private int postIndex = postorder.length - 1;
    public TreeNode constructPost(String[] postorder) {
        if (postorder[postIndex].equals(NN)) {
            postIndex--;
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;
        root.right = constructPost(postorder);
        root.left = constructPost(postorder);
        return root;
    }
}
