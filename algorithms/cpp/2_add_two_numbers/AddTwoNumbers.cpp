class AddTwoNumbers {
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		ListNode dummy(0);
		ListNode* prev = &dummy;
		int carry = 0;
		while (l1 != nullptr || l2 != nullptr) {
			int val1 = l1 == nullptr ? 0 : l1->val;
			int val2 = l2 == nullptr ? 0 : l2->val;
			int sum = carry + val1 + val2;
			prev->next = new ListNode(sum % 10);
			carry = sum / 10;
			if (l1 != nullptr) {
				l1 = l1->next;
			}
			if (l2 != nullptr) {
				l2 = l2->next;
			}
			prev = prev->next;
		}
		if (carry != 0) {
			prev->next = new ListNode(carry);
		}
		return dummy.next;
	}
};
