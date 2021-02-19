public class BinaryTreeSampling {
    
    // iterator
    public TreeNode sample1(TreeIterator iter) {
        TreeNode cur = null;
        int num = 0;
        while (iter.hasNext()) {
            TreeNode node = iter.next();
            int val = Math.random(++num);
            if (val == 0) {
                cur = node;
            }
        }
        return cur;
    }

    // divide & conquer
    static class ReturnType {
        TreeNode sample;
        int size;
        ReturnType(TreeNode sample, int size) {
            this.sample = sample;
            this.size = size;
        }
    }

    public ReturnType sample2(TreeNode root) {
        if (root == null) return new ReturnType(null, 0);
        ReturnType left = sample2(root.left);
        ReturnType right = sample2(root.right);
        int totalSize = left.size + right.size + 1;
        int randomPos = random(totalSize);
        if (randomPos < left.size) return new ReturnType(left.sample, totalSize);
        if (randomPos < left.size + right.size) return new ReturnType(right.sample, totalSize);
        return new ReturnType(root, totalSize);
    }
}
