class Remove {
public:
	ListNode* deleteDuplicates(ListNode* head) {
		ListNode dummy(0);
		dummy.next = head;
		ListNode* slow = &dummy;
		while (slow->next) {
			ListNode* fast = slow->next;
			while (fast->next && fast->val == fast->next->val) {
				ListNode* tmp = fast;
				fast = fast->next;
				delete tmp;
			}
			if (fast == slow->next) {
				slow = slow->next;
			} else {
				ListNode* tmp = fast;
				slow->next = fast->next;
				delete tmp;
			}
		}
		return dummy.next;
	}
};
