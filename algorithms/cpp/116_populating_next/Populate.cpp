class Populate {
public:
	Node* connect(Node* root) {
        if (root == NULL)
            return root;
        Node* head = root;
        while (head) {
            Node* cur = head;
            Node* prev = NULL;
            Node* next_head = NULL;
            while (cur) {
                if (cur->left) {
                    if (prev)
                        prev->next = cur->left;
                    prev = cur->left;
                    if (next_head == NULL)
                        next_head = cur->left;
                }
                if (cur->right) {
                    if (prev)
                        prev->next = cur->right;
                    prev = cur->right;
                    if (next_head == NULL)
                        next_head = cur->right;
                }
                cur = cur->next;
            }
            head = next_head;
        }
        return root;
    }
};
