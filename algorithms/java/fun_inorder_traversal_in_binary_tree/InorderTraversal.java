import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.tree.TreeNode;

import com.sun.tools.javac.util.List;

public class InorderTraversal {
    
    // 1. recursive way
    public void recursive(TreeNode root) {
        if (root == null) return;
        recursive(root.left);
        System.out.println(root.val);;
        recursive(root.right);
    }

    // 2. using stack
    public List<Integer> useStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        firstNode(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            firstNode(cur.right, stack);
        }
        return res;
    }
    private void firstNode(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
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
    private TreeNode firstNode(TreeNode cur) {
        if (cur == null) return null;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
    private TreeNode nextNode(TreeNode cur) {
        if (cur == null) return null;
        if (cur.right != null) return firstNode(cur.right);
        while (cur.parent != null && cur == cur.parent.right) {
            cur = cur.parent;
        }
        // cur.parent == null
        // cur = cur.parent.left
        return cur.parent;
    }
}