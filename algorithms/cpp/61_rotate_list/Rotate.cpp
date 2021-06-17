class Rotate {
public:
	ListNode* rotateRight(ListNode* head, int k) {
		if (head == nullptr || head->next == nullptr || k == 0) {
			return head;
		}
		int length = get_len(head);
		for (int i = 1; i < (length - k % length); ++i) {
			head = head->next;
		}
		ListNode* newHead = head->next;
		head->next = nullptr;
		return newHead;
	}
private:
	int get_len(ListNode* head) {
		int count = 1;
		ListNode* cur = head;
		while (cur->next != nullptr) {
			++count;
			cur = cur->next;
		}
		cur->next = head;
		return count;
	}
};
