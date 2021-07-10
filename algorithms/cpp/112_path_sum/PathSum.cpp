class PathSum {
public:
	bool hasPathSum(TreeNode* root, int target_sum) {
        if (root == NULL)
            return false;
        if (root->left == NULL && root->right == NULL) {
            return target_sum - root->val == 0;
        }
        return hasPathSum(root->left, target_sum - root->val) || hasPathSum(root->right, target_sum - root->val);
    }
};
