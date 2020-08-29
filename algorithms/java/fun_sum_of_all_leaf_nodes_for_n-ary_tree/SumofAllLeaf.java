public class SumofAllLeaf {
    
    static class TreeNode {
        int val;
        TreeNode parent;
        TreeNode eldestChild;
        TreeNode nextSibling;
    }
 
    public int sumAll(TreeNode root) {
        int sum = 0;
        TreeNode cur = firstNode(root);
        while (cur != null) {
            if (cur.eldesChild == null) sum += cur.val
            cur = nextNode(cur);
        }
        return res;
    }

    private TreeNode firstNode(TreeNode root) {
        return root;
    }
    
    private nextNode(TreeNode cur) {
        if (cur.eldestChild != null) return firstNode(cur.eldestChild);
        while (cur.parent != null && cur.nextSlibling == null) {
            cur = cur.parent;
        }
        return cur.nextSibling;
    }
}