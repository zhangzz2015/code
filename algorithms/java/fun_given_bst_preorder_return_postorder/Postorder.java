public class Postorder {
    public List<Integer> getPostorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        List<Integer> res = new ArrayList<>();
        getPostorder(preorder, Integer.MAX_VALUE, res);
        return res;
    }
        private int preIndex = 0;
        private void getPostorder(int[] preorder, int nextInorderValue, List<Integer> res) {
            if (preIndex == preorder.length || preorder[preIndex] == nextInorderValue) {
                return null;
            }
            int root = preorder[preIndex++];
            getPostorder(preorder, root, res);
            getPostorder(preorder, nextInorderValue, res);
            res.add(root);
        }
}
