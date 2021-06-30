class Recover {
private:
	struct State {
        TreeNode* prev;
        TreeNode* node1;
        TreeNode* node2;
        State() : prev(nullptr), node1(nullptr), node2(nullptr) {}
    };

    void inorder(TreeNode* root, State* state) {
        if (root == NULL) {
            return;
        }
        inorder(root->left, state);
        if (state->prev != NULL && state->prev->val > root->val) {
            if (state->node1 == NULL) {
                state->node1 = state->prev;
            }
            state->node2 = root;
        }
        state->prev = root;
        inorder(root->right, state);
    }
public:
	void recoverTree(TreeNode* root) {
        State state;
        inorder(root, &state);
        swap(state.node1->val, state.node2->val);
    }
};
