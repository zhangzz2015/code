import java.util.Deque;

public class PostorderTraversal {

    // 1. recursive
    public void recursive(TreeNode root) {
        if (root == null) return;
        recursive(root.left);
        recursive(root.right);
        System.out.println(root.val);
    }

    // 2. use stack
    public List<String> useStack(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (prev == null || cur == prev.left || cur == prev.right) { // go down
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else { // leaf
                    stack.pop();
                    res.add(cur.val);
                }
            } else if (prev == cur.right || (prev == cur.left && cur.right == null)) {
                stack.poll();
                res.add(cur.val);
            } else { // go from left side to right side
                stack.push(cur.right);
            }
            prev = cur;
        }
        return res;
    }

    // parent pointer
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
        if (root == null) return null;
        while (root.left != null || root.right != null) {
            if (root.left != null) root = root.left;
            else root = root.right;
        }
        return root;
    }
    private TreeNode nextNode(TreeNode cur) {
        if (cur == null) return null;
        // cur.parent == null;
        if (cur.parent == null) return null;
        // cur == parent.right return parent
        // cur == parent.left
		//		if parent.right == null return parent
		//		else parent.right != null firstNode(parent.right)
        if (cur == cur.parent.left && cur.parent.right != null) return firstNode(cur.parent.right);
        return cur.parent;
    }
}
