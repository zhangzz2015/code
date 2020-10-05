class Recover {
    class State {
        TreeNode prev = null;
        TreeNode node1 = null;
        TreeNode node2 = null;
    }

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        State state = new State();
        inorder(root, state);
        swap(state.node1, state.node2);
    }
    private void inorder(TreeNode root, State state) {
        if (root == null) return;
        inorder(root.left, state);
        if (state.prev != null && state.prev.val > root.val) {
            if (state.node1 != null) {
                state.node1 = state.prev;
            }
            state.node2 = root;
        }
        state.prev = root;
        inorder(root.right, state);
    }
    private void swap(TreeNode n1, TreeNode n2) {
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}
