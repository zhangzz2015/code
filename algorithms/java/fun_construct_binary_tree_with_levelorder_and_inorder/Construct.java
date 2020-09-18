public class Construct {
    public TreeNode construct(int[] inorder, int[] levelorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        List<Integer> levelList = new ArrayList<>();
        for (int num : levelorder) {
            levelList.add(num);
        }
        return construct(levelList, inMap);
    }

    private TreeNode construct(List<Integer> levelList, Map<Integer, Integer> inMap) {
        if (levelList.isEmpty()) return null;
        TreeNode root = new TreeNode(levelList.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : levelList) {
            if (inMap.get(num) < inMap.get(root.val)) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
        root.left = construct(left, inMap);
        root.right = construct(right, inMap);
        return root;
    }
}
