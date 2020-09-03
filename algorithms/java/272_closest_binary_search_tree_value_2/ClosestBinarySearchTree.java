import java.util.ArrayDeque;
import java.util.Deque;

import javax.swing.tree.TreeNode;

public class ClosestBinarySearchTree {
    
    // 1. sliding window
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if (root == null || k < 1) {
            return new ArrayList<>();
        }
        Deque<Integer> window = new ArrayList<>();
        inorder(root, target, k, window);
        return new ArrayList<>(window);
    }
    private void inorder(TreeNode root, double target, int k, Deque<Integer> window) {
        if (root == null) return;
        inorder(root.left, target, k, window);
        window.offerLast(root.val);
        if (window.size() > k) {
            if (Math.abs(window.peekLast() - target) > Math.abs(window.peekFirst() - target)) {
                window.pollLast();
                return;
            }
            window.pollFirst();
        }
        inorder(root.right, target, k, window);
    }

    // 2. iterator
    public List<Integer> closestKValues1(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null || k == 0) return res;
        AscIterator ascIterator = new AscIterator(root, target);
        DesIterator desIterator = new DesIterator(root, target);
        TreeNode nextSmaller = desIterator.next();
        TreeNode nextLarger = ascIterator.next();
        for (int i = 0; i < k; i++) {
            if (nextSmaller == null && nextLarger == null) {
                return new ArrayList<>();
            } else if (nextSmaller == null || (nextLarger != null && isCloser(nextSmaller, nextLarger, target) == nextLarger)) {
                res.add(nextLarger.val);
                nextLarger = ascIterator.next();
            } else if (nextLarger == null || (nextSmaller != null && isCloser(nextSmaller, nextLarger, target) == nextSmaller)) {
                res.add(nextSmaller.val);
                nextSmaller = desIterator.next();
            }
        }
        return res;
    }

    private TreeNode isCloser(TreeNode nextSmaller, TreeNode nextLarger, double target) {
        if (Math.abs(nextSmaller.val - target) < Math.abs(nextLarger.val - target)) {
            return nextSmaller;
        } else {
            return nextLarger;
        }
    }
}

class AscIterator { // starting from the smallest larger
    private Deque<TreeNode> stack;
    AscIterator(TreeNode root, double target) {
        stack = new ArrayDeque<>();
        while (root != null) {
            if (root.val > target) {
                stack.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public TreeNode next() {
        if (!hasNext()) return null;
        TreeNode cur = stack.pop();
        TreeNode res = cur;
        cur = cur.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return res;
    }
}

class DescIterator { // starting from the largest smaller or equal
    private Deque<TreeNode> stack;
    DescIterator(TreeNode root, double target) {
        stack = new ArrayDeque<>();
        while (root != null) {
            if (root.val <= target) {
                stack.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public TreeNode next() {
        if (!hasNext()) return null;
        TreeNode cur = stack.pop();
        TreeNode res = cur;
        cur = cur.left;
        while (cur != null) {
            stack.push(cur);
            cur = cur.right;
        }
        return res;
    }
}
