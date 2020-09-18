public class Contruct {
    
    // 1. using hashmap
    public TreeNode constructTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inorderMap = buildMap(inorder);
        return construct1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode construct1(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> inorderMap) {
        if (pStart > pEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int inIndex = inorderMap.get(root.val);
        int leftSize = inIndex - iStart;
        int rightSize = iEnd - inIndex;
        root.left = construct1(preorder, pStart + 1, pStart + leftSize, inorder, iStart, inIndex - 1, inorderMap);
        root.right = construct1(preorder, pEnd - rightSize + 1, pEnd, inorder, inIndex + 1, iEnd, inorderMap);
        return root;
    }

    private Map<Integer, Integer> buildMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    } 

    
    // 2. doing both together
    public TreeNode constructTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return construct2(preorder, inorder, Integer.MAX_VALUE);
    }
    private int preIndex = 0;
    private int inIndex = 0;
    private TreeNode construct2(int[] preorder, int[] inorder, int nextInorderValue) {
        // base case: we need to know when the current subtree is finished
        if (inIndex == inorder.length || inorder[inIndex] == nextInorderValue) return null;
        // preorder
        TreeNode root = new TreeNode(preorder[preIndex]);
        preIndex++;
        root.left = construct2(preorder, inorder, root.val);
        // inorder
        inIndex++; // traverse root itself
        root.right = construct2(preorder, inorder, nextInorderValue);
        return root;
    }
}
