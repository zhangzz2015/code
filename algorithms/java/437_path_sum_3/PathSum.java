public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return countPathSum(root, sum, map, 0);
    }
    
    private int countPathSum(TreeNode root, int target, Map<Integer, Integer> map, int curSum) {
        if (root == null) return 0;
        curSum += root.val;
        int count = map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        count += countPathSum(root.left, target, map, curSum);
        count += countPathSum(root.right, target, map, curSum);
        Integer curCount = map.get(curSum);
        if (curCount == 1) {
            map.remove(curSum);
        } else {
            map.put(curSum, curCount - 1);
        }
        return count;
    }
}