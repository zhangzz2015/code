class Flatten {
public:
	/*
	* not using a globel pointer
	* link the curent right node to the current left node's right most node
	*/
	void flatten(TreeNode* root) {
        if (!root || (!root->left && !root->right))
            return;
        if (root->left) {
            flatten(root->left);
            
            TreeNode* tmp = root->right;
            root->right = root->left;
            root->left = NULL;
            
            TreeNode* cur = root->right;
            while (cur->right != NULL)
                cur = cur->right;
            cur->right = tmp;
        }
        flatten(root->right);
    }
};
