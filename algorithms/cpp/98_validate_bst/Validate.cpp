class Validate {
public:
    bool isValidBST(TreeNode* root) {
        return is_valid(root, NULL, NULL);
    }
private:
    bool is_valid(TreeNode* root, TreeNode* min_node, TreeNode* max_node) {
        if (root == NULL) {
            return true;
        }
        if ((min_node && root->val <= min_node->val) || (max_node && root->val >= max_node->val)) {
            return false;
        }
        return is_valid(root->left, min_node, root) && is_valid(root->right, root, max_node);
    }
};
