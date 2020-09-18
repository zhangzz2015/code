public class Check {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        return verify(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int preIndex = 0;
    private boolean verify(int[] preorder, int min, int max /*nextInOrderValue*/) {
        if (preIndex == preorder.length || preorder[preIndex] > max) return true;
        if (preorder[preIndex] <= min) return false;
        int rootValue = preorder[preIndex++];
        return verify(preorder, min, rootValue) && verify(preorder, rootValue, max);
    }
}
