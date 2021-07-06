class Zigzag {
public:
	// bfs
	vector<vector<int>> zigzagLevelOrder_bfs(TreeNode* root) {
        vector<vector<int>> res;
        if (root == NULL)
            return res;
        deque<TreeNode*> deque;
        deque.push_back(root);
        int level = 0;
        while (!deque.empty()) {
            int size = deque.size();
            vector<int> cur_level;
            for (int i = 0; i < size; ++i) {
                if (level % 2 == 0) {
                    TreeNode* cur = deque.front();
                    deque.pop_front();
                    cur_level.push_back(cur->val);
                    if (cur->left != NULL) {
                        deque.push_back(cur->left);
                    }
                    if (cur-> right != NULL) {
                        deque.push_back(cur->right);
                    }
                } else {
                    TreeNode* cur = deque.back();
                    deque.pop_back();
                    cur_level.push_back(cur->val);
                    if (cur->right != NULL) {
                        deque.push_front(cur->right);
                    }
                    if (cur->left != NULL) {
                        deque.push_front(cur->left);
                    }
                }
            }
            level++;
            res.push_back(cur_level);
        }
        return res;
    }
	
	// dfs
	vector<vector<int>> zigzagLevelOrder_dfs(TreeNode* root) {
        vector<vector<int>> res;
        if (root == NULL)
            return res;
        dfs(root, res, 0);
        return res;
    }
    void dfs(TreeNode* root, vector<vector<int>>& res, int level) {
        if (root == NULL)
            return;
        if (level >= res.size()) {
            vector<int> new_level{root->val};
            res.push_back(new_level);
        } else {
            if (level % 2 == 0) {
                res[level].push_back(root->val);
            } else {
                res[level].insert(res[level].begin(), root->val);
            }
        }
        dfs(root->left, res, level + 1);
        dfs(root->right, res, level + 1);
    }	
};
