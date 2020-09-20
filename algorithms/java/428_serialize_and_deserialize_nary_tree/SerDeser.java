class SerDeser {
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    private void dfs(Node root, StringBuilder sb) {
        sb.append("[");
        sb.append(root.val);
        for (Node child : root.children) {
            dfs(child, sb);
        }
        sb.append("]");
    }

    
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        int[] index = new int[1];
        return construct(data, index);
    }
    private Node construct(String data, int[] index) {
        index[0]++;
        int nextInt = 0;
        while (data.charAt(index[0]) != '[' && data.charAt(index[0]) != ']') {
            nextInt = nextInt * 10 + data.charAt(index[0]) - '0';
            index[0]++;
        }
        Node root = new Node(nextInt, new ArrayList<>());
        while (data.charAt(index[0]) != ']') {
            root.children.add(construct(data,index));
        }
        index[0]++;
        return root;
    }
}
