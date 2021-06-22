class Remove {
public:
	ListNode* deleteDuplicates(ListNode* head) {
		ListNode* cur = head;
		while (cur && cur->next) {
			if (cur->val == cur->next->val) {
				ListNode* tmp = cur->next;
				cur->next = tmp->next;
				delete tmp;
			} else {
				cur = cur->next;
			}
		}
		return head;
	}
};
