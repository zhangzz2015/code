import java.util.Deque;
import java.util.NoSuchElementException;

import javax.swing.tree.TreeNode;

import com.sun.tools.javac.util.List;

public class KthLargestInBST {

    // 1. recursive way
    public int kthLargest(TreeNode root, int k) {
        List<TreeNode> res = new ArrayList<>();
        reverseInorder(root, res, k);
        if (res.size() == k) return res.get(k - 1).val;
        else throw new IllegalArgumentException("There is no k elements in the tree.");
    }

    private void reverseInorder(TreeNode root, List<TreeNode> res, int k) {
        reverseInorder(root.right, res, k);
        if (res.size() == k) return;
        res.add(root);
        if (res.size() == k) return;
        reverseInorder(root.left, res, k);
    }

    // 2. iterative way
    private static class ReverseInorderIterator {
        Deque<TreeNode> stack;
        public ReverseInorderIterator(TreeNode root) {
            stack = new ArrayDeqeue<>();
            firstNode(root);
        }

        public TreeNode next() {
            if (!hasNext()) throw NoSuchElementException();
            TreeNode cur = stack.pop();
            firstNode(cur.left);
            return cur;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void firstNode(TreeNode root) {
            while (root != null) {
                stack.push(root.right);
                root = root.right;
            }
        }
    }

    public int kthLargestIterative(TreeNode root, int k) {
        ReverseInorderIterator iter = new ReverseInorderIterator(root);
        TreeNode res = null;
        while(iter.hasNext() && k > 0) {
            res = iter.next();
            k--;
        }
        if (res != null) return res.val;
        else throw new IllegalArgumentException("There is no k elements in the tree.");
    }
}