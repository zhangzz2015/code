public class Construct {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;
        int[] inIndex = new int[]{inorder.length - 1};
        int[] postIndex = new int[]{postorder.length - 1};
        return construct(inorder, postorder, inIndex, postIndex, Integer.MAX_VALUE);    
    }
    // left right root
    private TreeNode construct(int[] inorder, int[] postorder, int[] inIndex, int[] postIndex, int nextInorderValue) {
        if (postIndex[0] < 0 || inorder[inIndex[0]] == nextInorderValue) return null;
        TreeNode root = new TreeNode(postorder[postIndex[0]]);
        postIndex[0]--;
        root.right = construct(inorder, postorder, inIndex, postIndex, root.val);
        inIndex[0]--;
        root.left = construct(inorder, postorder, inIndex, postIndex, nextInorderValue);
        return root;
    }
}
