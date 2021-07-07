class Construct {
public:
	TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int in_index = inorder.size() - 1;
        int po_index = postorder.size() - 1;
        return construct(inorder, in_index, postorder, po_index, INT_MAX);
    }
private:
    TreeNode* construct(vector<int>& inorder, int& in_index, vector<int>& postorder, int& po_index, int next_in_val) {
        if (po_index < 0 || inorder[in_index] == next_in_val)
            return NULL;
        TreeNode* root = new TreeNode(postorder[po_index]);
        --po_index;
        root->right = construct(inorder, in_index, postorder, po_index, root->val);
        --in_index;
        root->left = construct(inorder, in_index, postorder, po_index, next_in_val);
        return root;
    }
};
