class Reverse {
public:
	ListNode* reverseBetween(ListNode* head, int left, int right) {
		ListNode dummy(0);
		dummy.next = head;
		ListNode* prev = &dummy;
		for (int i = 0; i < left - 1; ++i) {
			prev = prev->next;
		}
		ListNode* start = prev->next;
		ListNode* next = start->next;
		for (int i = 0; i < right - left; ++i) {
			start->next = next->next;
			next->next = prev->next;
			prev->next = next;
			next = start->next;
		}
		return dummy.next;
	}
};
