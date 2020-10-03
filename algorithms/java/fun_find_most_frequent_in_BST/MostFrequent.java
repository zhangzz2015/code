class MostFrequent {
    static class State {
        TreeNode maxValue;
        int maxFreq;
        TreeNode prevValue;
        int prevCount;
        State(TreeNode maxValue, int maxFreq, TreeNode prevValue, int prevCount) {
            this.maxValue = maxValue;
            this.maxFreq = maxFreq;
            this.prevValue = prevValue;
            this.prevCount = prevCount;
        }
    }

    public TreeNode mostFrequent(TreeNode root) {
        State state = new State(null, 0, null, 0);
        inorder(root, state);
        return state.maxValue;
    }

    private void inorder(TreeNode root, State state) {
        if (root == null) return;
        inorder(root.left, state);
        if (prevValue == null || state.prevValue != root.val) {
            state.prevValue = root;
            state.prevCount = 1;
        } else {
            state.prevCount++;
        }
        if (state.prevCount > state.maxFreq) {
            state.maxFreq = state.prevCount;
            state.maxValue = state.prevValue;
        }
        inorder(root.right, state);
    }
}
