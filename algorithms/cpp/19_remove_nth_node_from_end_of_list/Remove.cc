class Remove {
public:
	ListNode* removeNthFromEnd(ListNode* head, int n) {
		if (!head)
			return nullptr;
		ListNode* fast = head;
		while (fast != nullptr && n > 0) {
			fast = fast->next;
			n--;
		}
		// if n is not guaranteed to be smaller then size of the list
		// fast != null n == 0
		// fast == null n == 0
		// fast == null n > 0
		ListNode dummy(0);
		dummy.next = head;
		ListNode* cur = &dummy;
		while (fast != nullptr) {
			fast = fast->next;
			cur = cur->next;
		}
		cur->next = cur->next->next;
		return dummy.next;
	}
};
