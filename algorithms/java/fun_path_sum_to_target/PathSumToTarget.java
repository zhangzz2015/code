import java.util.Set;

public class PathSumToTarget {
    public boolean findTarget(TreeNode root, int target) {
        Set<Integer> prefixSums = new HashSet<>();
        prefixSums.add(0);
        return findTarget(root, target, 0, prefixSums);
    }

    private boolean findTarget(TreeNode cur, int target, int prevSum, Set<Integer> prefixSums) {
        if (cur == null) return false;
        // 1. what do we do for the current node
        int curSum = prevSum + cur.val;
        if (prefixSums.contains(curSum - target)) return true;
        boolean nonExisted = prefixSums.add(curSum);
        // 2. backtracking
        if (findTarget(cur.left, target, curSum, prefixSums)) return true;
        if (findTarget(cur.right, target, curSum, prefixSums)) return true;
        // 3. recovery!!
        if (nonExisted) prefixSums.remove(curSum);
        return false;
    }
}