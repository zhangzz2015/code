class Level {
public:
	// 1. bfs
	vector<vector<int>> levelOrder_bfs(TreeNode* root) {
		vector<vector<int>> res;
        if (root == NULL)
            return res;
        queue<TreeNode*> queue;
        queue.push(root);
        while (!queue.empty()) {
            int size = queue.size();
            vector<int> cur_level;
            for (int i = 0; i < size; ++i) {
                TreeNode* cur = queue.front();
                queue.pop();
                cur_level.push_back(cur->val);
                if (cur->left)
                    queue.push(cur->left);
                if (cur->right)
                    queue.push(cur->right);
            }
            res.emplace_back(cur_level);
        }
        return res;
	}
	// 2. dfs
	vector<vector<int>> levelOrder_dfs(TreeNode* root) {
		vector<vector<int>> res;
		dfs(res, root, 0);
		return res;
	}

	void dfs(vector<vector<int>>& res, TreeNode* root, int level) {
		if (root == NULL)
			return;
		if (res.size() == level)
			res.push_back({});
		res[level].push_back(root->val);
		dfs(res, root->left, level + 1);
		dfs(res, root->right, level + 1);
	}
};
