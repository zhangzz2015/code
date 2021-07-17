class Populate {
public:
	// dfs
	Node* connect(Node* root) {
        vector<Node*> tails;
        dfs(tails, root, 0);
        return root;
    }
    void dfs(vector<Node*>& tails, Node* root, int level) {
        if (root == NULL)
            return;
        if (tails.size() == level) {
            tails.push_back(root);
        } else {
            tails[level]->next = root;
            tails[level] = root;
        }
        dfs(tails, root->left, level + 1);
        dfs(tails, root->right, level + 1);
    }
};
