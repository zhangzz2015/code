public class ClosestValue {

    // 1. recursion
    public int closestValue(TreeNode root, double target) {
        return closest(root, target, root.val);
    }
    private int closest(TreeNode root, double target, int closest) {
        if (Math.abs(target - closest) > Math.abs(target - root.val)) {
            closest = root.val;
        }
        if (target < root.val && root.left != null) {
            return closest(root.left, target, closest);
        } else if (target > root.val && root.right != null) {
            return closest(root.right, target, closest);
        } else {
            return closest;
        }
    }

    // 2. iterative
    public int closestValue1(TreeNode root, double target) {
        return closest1(root, target, root.val);
    }
    private int closest1(TreeNode root, double target, int closest) {
        TreeNode cur = root;
        while (cur != null) {
            if (Math.abs(target - closest) > Math.abs(target - cur.val)) {
                closest = cur.val;
            }
            if (target < cur.val) {
                cur = cur.left;
            } else if (target > cur.val) {
                cur = cur.right;
            } else {
                break;
            }
            return closest;
        }
    }
}