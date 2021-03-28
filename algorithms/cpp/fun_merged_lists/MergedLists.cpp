class MergedLists {
public:
	bool check_lists_join(ListNode* a, ListNode* b) {
		if (!a && !b) {
			return true;
		} else if (!a || !b) {
			return false;
		}
		ListNode* a_tail = get_tail(a);
		ListNode* b_tail = get_tail(b);
		if (!a_tail->next && !b_tail->next) {
			// neither list have cycle
			return a_tail == b_tail;
		} else if (a_tail->next && b_tail->next) {
			// both lists have cycle
			return is_same_cycle(a_tail, b_tail);
		} else {
			// one has cycle the other does not
			return false;
		}
	}
private:
	// if no cycle return tail, else return some node in the cycle
	ListNode* get_tail(ListNode* head) {
		ListNode *slow = head, *fast = head;
		while (fast->next && fast->next->next) {
			slow = slow->next;
			fast = fast->next->next;
			if (slow == fast) {
				return slow;
			}
		}
		return fast->next ? fast->next : fast;
	}
	bool is_same_cycle(ListNode* a, ListNode* b) {
		ListNode* cur = a->next;
		while (cur != a) {
			if (cur == b) {
				return true;
			}
			cur = cur->next;
		}
		return false;
	}
};
