class Swap {
public:
	// iterative
	ListNode* swapPairsIterative(ListNode* head) {
		if (!head || !head->next) {
			return head;
		}
		ListNode dummy(0);
		ListNode* prev = &dummy;
		while (head && head->next) {
			ListNode* next = head->next->next;
			prev->next = head->next;
			head->next->next = head;
			head->next = next;
			prev = head;
			head = next;
		}
		return dummy.next;
	}

	// recursive
	ListNode* swapPairsRecursive(ListNode* head) {
		if (!head || !head->next) {
            return head;
        }
        ListNode* next = head->next;
        head->next = swapPairsRecursive(head->next->next);
        next->next = head;
        return next;
	}
};
