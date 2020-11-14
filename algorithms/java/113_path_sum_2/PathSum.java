class PathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        pathSum(res, sum, new ArrayList<>(), 0, root);
        return res;
    }
    private void pathSum(List<List<Integer>> res, int sum, List<Integer> curPath, int curSum, TreeNode root) {
        curSum += root.val;
        curPath.add(root.val);
        if (root.left == null && root.right == null && curSum == sum) {
            res.add(new ArrayList<>(curPath));
            curPath.remove(curPath.size() - 1);
            return;
        }
        if (root.left != null) {
            pathSum(res, sum, curPath, curSum, root.left);
        }
        if (root.right != null) {
            pathSum(res, sum, curPath, curSum, root.right);
        }
        curPath.remove(curPath.size() - 1);
    }
}
