public class ChangeValueToPrefixsum {
    
    // 1. inorder traversal
    int prefixSum = 0;
    public void changeBST1(TreeNode root) {
        if (root == null) {
            return;
        }
        changeBST(root.left);
        prefixSum += root.value;
        root.value = prefixSum;
        changeBST(root.right);
    }

    // 2. prefixsum = root path sum + left subtree sum
    public void changeBST2(TreeNode root) {
        changeBST2(root, 0);
    }

    public int changeBST2(TreeNode root, int path) {
        if (root == null) return 0;
        int leftSum = changeBST(root.left, path);
        int curValue = root.val;
        root.value = path + leftSum + root.value;
        int rightSum = changeBST(root.right, root.value);
        return leftSum + rightSum + curValue;
    }

    // 3. return value is the prefixsum
    public int changeBST3(TreeNode root, int preSum) {
        if (root == null) return preSum;
        root.value += changeBST3(root.left, preSum);
        return changeBST3(root.right, root.value);
    }
}
