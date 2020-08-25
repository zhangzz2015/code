import java.util.Deque;

import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

public class PreorderTraversal {
    
    // 1. recursive
    public void recursive(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        recursive(root.left);
        recursive(root.right);
    }

    // 2. use stack
    public List<Integer> useStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        firstNode(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                firstNode(cur.right, stack);
            }
            if (cur.left != null) {
                firstNode(cur.left, stack);
            }
            res.add(cur.val);
        }
    }
    private void firstNode(TreeNode cur, Deque<TreeNode> stack) {
        stack.push(cur);
    }

    // 3. parent pointer
    /*
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }
    */
    public List<Integer> parentPointer(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = firstNode(root);
        while (cur != null) {
            res.add(cur.val);
            cur = nextNode(cur);
        }
        return res;
    }
    private TreeNode firstNode(TreeNode root) {
        return root;
    }
    private TreeNode nextNode(TreeNode cur) {
        if (cur == null) return null;
        // case 1 - cur.left
        if (cur.left != null) return firstNode(cur.left);
        // case 2 - cur.right
        if (cur.right != null) return firstNode(cur.right);
        // case3 - both not null
        while (cur.parent != null && (cur == cur.parent.right || cur.parent.right == null)) {
            cur = cur.parent;
        }
        // cur.parent == null
        // cur = cur.parent.left && cur.parent.right != null: go to right
        if (cur.parent == null) return null;
        return firstNode(cur.parent.right);
    }
}