class Merge {
public:
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
		ListNode dummy(0);
		ListNode* tail = &dummy;
		while (l1 != nullptr || l2 != nullptr) {
			int val1 = l1 == nullptr ? INT_MAX : l1->val;
			int val2 = l2 == nullptr ? INT_MAX : l2->val;
			if (val1 <= val2) {
				tail->next = l1;
				l1 = l1 == nullptr ? l1 : l1->next;
			} else {
				tail->next = l2;
				l2 = l2 == nullptr ? l2 : l2->next;
			}
			tail = tail->next;
		}
		return dummy.next;
	}
};
