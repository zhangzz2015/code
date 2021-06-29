class Unique {
public:
	vector<TreeNode*> generateTrees(int n) {
        if (n == 0) 
            return {};
        return construct(1, n);
    }
private:
    vector<TreeNode*> construct(int start, int end) {
        vector<TreeNode*> list;
        if (start > end) {
            list.push_back(nullptr);
            return list;
        }
        for (int i = start; i <= end; ++i) {
            vector<TreeNode*> left = construct(start, i - 1);
            vector<TreeNode*> right = construct(i + 1, end);
            for (TreeNode* l : left) {
                for (TreeNode* r : right) {
                    TreeNode* root = new TreeNode(i);
                    root->left = l, root->right = r;
                    list.push_back(root);
                }
            }
        }
        return list;
    }
};
