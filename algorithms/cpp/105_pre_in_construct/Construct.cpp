class Construct {
public:
	// recursion
	TreeNode* buildTree_rec(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int, int> inorder_map;
        for (int i = 0; i < inorder.size(); ++i) {
            inorder_map[inorder[i]] = i;
        }
        return construct1(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, inorder_map);
    }

    TreeNode* construct1(vector<int>& preorder, int p_start, int p_end, vector<int>& inorder, int i_start, int i_end, unordered_map<int, int>& inorder_map) {
        if (p_start > p_end)
            return NULL;
        TreeNode* root = new TreeNode(preorder[p_start]);
        int in_index = inorder_map[root->val];
        int left_size = in_index - i_start;
        int right_size = i_end - in_index;
        root->left = construct1(preorder, p_start + 1, p_start + left_size, inorder, i_start, in_index - 1, inorder_map);
        root->right = construct1(preorder, p_end - right_size + 1, p_end, inorder, in_index + 1, i_end, inorder_map);
        return root;
    }

	// traverse while construct
	TreeNode* buildTree_traverse(vector<int>& preorder, vector<int>& inorder) {
        return construct2(preorder, inorder, INT_MAX);
    }
    int pre_index = 0;
    int in_index = 0;
    TreeNode* construct2(vector<int>& preorder, vector<int>& inorder, int next_inorder_val) {
        if (in_index == inorder.size() || inorder[in_index] == next_inorder_val)
            return NULL;
        TreeNode* root = new TreeNode(preorder[pre_index]);
        ++pre_index;
        root->left = construct2(preorder, inorder, root->val);
        ++in_index;
        root->right = construct2(preorder, inorder, next_inorder_val);
        return root;
    }
};
