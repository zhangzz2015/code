public class Convert3aryTree {
    
    static class TreeNode {
        TreeNode c1;
        TreeNode c2;
        TreeNode c3; // next
    }

    // 1. preorder traversal
    // because this is preorder so the head is still the original tree root
    TreeNode prev = null;
    public void preOrder(TreeNode cur) {
        if (cur == null) return;
        // connect prev and cur
        if (prev != null) {
            prev.c3 = cur;
        }
        prev = cur;
        TreeNode c3 = cur.c3;
        preOrder(cur.c1);
        preOrder(cur.c2);
        preOrder(c3);
        cur.c1 = null;
        cur.c2 = null;
    }

    // 2, pure recursion
    public TreeNode preOrderFlatten(TreeNode root) {
        if (root == null) return null;
        // preorder call recursion, we can do that when we connect
        //TreeNode node1 = preOrderFlatten(root.c1);
        //TreeNode node2 = preOrderFlatten(root.c2);
        //TreeNode node3 = preOrderFlatten(root.c3);
        // connect the tail and head follow root-c1-c2-c3
        TreeNode tail = root;
        TreeNode c3 = root.c3; // we need to use c3 as the next pointer thus we need the save that before it changes
        tail = connect(tail, root.c1, preOrderFlatten(root.c1));
        tail = connect(tail, root.c2, preOrderFlatten(root.c2));
        tail = connect(tail, c3, preOrderFlatten(c3));
        root.c1 = null;
        root.c2 = null;
        return tail;
    }

    private TreeNode connect(TreeNode prevTail, TreeNode head, TreeNode tail) {
        if (head == null) return prevTail;
        prevTail.c3 = head;
        return tail;
    }
}
