public class Construct {
    public TreeNode construct(int[] level) {
        if (level == null || level.length == 0) return null;
        List<Integer> list = new ArrayList<>();
        for (int num : level) list.add(num);
        return construct(list);
    }
    private TreeNode construct(List<Integer> list) {
        if (list.isEmpty()) return null;
        TreeNode root = new TreeNode(list.get(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < root.val) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }
        root.left = construct(left);
        root.right = construct(right);
        return root;
    }
}
