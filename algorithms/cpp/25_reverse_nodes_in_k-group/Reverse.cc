class Reverse {
public:
	// recursive
	ListNode* reverseKGroupRecursive(ListNode* head, int k) {
		if (head == nullptr) {
			return nullptr;
		}
		ListNode* cur = head;
		int count = 0;
		while (cur != nullptr && count < k) {
			count++;
			cur = cur->next;
		}
		if (count < k) {
			return head;
		}
		cur = reverseKGroupRecursive(cur, k);
		while (count-- > 0) {
			ListNode* tmp = head->next;
			head->next = cur;
			cur = head;
			head = tmp;
		}
		return cur;
	}

	// itetative
	ListNode* reverseKGroupIterative(ListNode* head, int k) {
		ListNode dummy(0);
		ListNode* prev = &dummy;
		ListNode* cur = head;
		while (cur != nullptr) {
			ListNode* kNode = getK(cur, k);
			if (kNode == nullptr) {
				return dummy.next;
			}
			ListNode* next = kNode->next;
			kNode->next = nullptr;
			prev->next = reverse(cur);
			cur->next = next;
			prev = cur;
			cur = next;
		}
		return dummy.next;
	}
private:
	ListNode* getK(ListNode* cur, int k) {
		while (cur != nullptr && k > 1) {
			k--;
			cur = cur->next;
		}
		return cur;
	}
	ListNode* reverse(ListNode* head) {
		ListNode* prev = nullptr;
		while (head != nullptr) {
			ListNode* next = head->next;
			head->next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
};
