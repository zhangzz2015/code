class Convert {
public:
	// O(nlogn) recursion
    TreeNode* sortedListToBST(ListNode* head) {
        return construct(head);
    }
    TreeNode* construct(ListNode* head) {
        if (head == NULL)
            return NULL;
        if (head->next == NULL)
            return new TreeNode(head->val);
        ListNode* mid = find_mid(head);
        TreeNode* root = new TreeNode(mid->val);
        root->left = construct(head);
        root->right = construct(mid->next);
        return root;
    }
    ListNode* find_mid(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* prev = head;
        while (fast && fast->next) {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        prev->next = NULL;
        return slow;
    }

	// O(n) recursion
	TreeNode* sortedListToBST1(ListNode* head) {
        if (head == NULL)
            return NULL;
        int len = get_len(head);
        ListNode* cur = head;
        return construct1(0, len - 1, cur);
    }
    TreeNode* construct1(int start, int end, ListNode*& cur) {
        if (start > end)
            return NULL;
        int mid = start + (end - start) / 2;
        TreeNode* left = construct1(start, mid - 1, cur);
        TreeNode* root = new TreeNode(cur->val);
        cur = cur->next;
        root->right = construct1(mid + 1, end, cur);
        root->left = left;
        return root;
    }
    int get_len(ListNode* head) {
        int len = 0;
        while (head) {
            head = head->next;
            ++len;
        }
        return len;
    }
};
