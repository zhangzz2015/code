class SerDeser {
    
    private static final String DELIMITER = ",";
    private static final String NN = "#";

    // 1. preorder with special character    
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NN).append(DELIMITER);
            return;
        }
        sb.append(root.val).append(DELIMITER);
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(DELIMITER);
        int[] index = new int[1];
        return construct(nodes, index);
    }
    private TreeNode construct(String[] nodes, int[] index) {
        if (nodes[index[0]].equals(NN)) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index[0]]));
        index[0]++;
        root.left = construct(nodes, index);
        root.right = construct(nodes, index);
        return root;
    }

    
    // 2. levelorder with special character
    public String serializeLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append(NN).append(DELIMITER);
            } else {
                sb.append(cur.val).append(DELIMITER);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserializeLevel(String data) {
        String[] nodes = data.split(DELIMITER);
        if (nodes[0].equals(NN)) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        queue.offer(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode parent = queue.poll();
            if (!nodes[i].equals(NN)) {
                parent.left = new TreeNode(Integer.valueOf(nodes[i]));
                queue.offer(parent.left);
            }
            i++;
            if (!nodes[i].equals(NN)) {
                parent.right = new TreeNode(Integer.valueOf(nodes[i]));
                queue.offer(parent.right);
            }
        }
        return root;
    }
}