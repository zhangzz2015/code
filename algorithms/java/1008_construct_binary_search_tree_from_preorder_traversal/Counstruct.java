public class Construct {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }
    private int preIndex = 0;
    private TreeNode bstFromPreorder(int[] preorder, int nextInorderValue) {
        if (preIndex == preorder.length || prorder[preIndex] == nexInorderValue) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, nexInorderValue);
        return root;
    }
}
