class PathSum {
public:
	vector<vector<int>> pathSum(TreeNode* root, int target_sum) {
        if (root == NULL) {
            return {};
        }
        vector<vector<int>> res;
        vector<int> cur;
        dfs(res, cur, root, target_sum);
        return res;
    }
    void dfs(vector<vector<int>>& res, vector<int>& cur, TreeNode* root, int target_sum) {
        cur.push_back(root->val);
        if (root->left == NULL && root->right == NULL) {
            if (target_sum == root->val) {
                res.push_back(cur);
            }
            cur.pop_back();
            return;
        }
        if (root->left) 
            dfs(res, cur, root->left, target_sum - root->val);
        if (root->right)
            dfs(res, cur, root->right, target_sum - root->val);
        cur.pop_back();
    }
};
