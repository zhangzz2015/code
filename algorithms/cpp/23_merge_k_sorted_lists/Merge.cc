class Merge {
public:
	ListNode* mergeKLists(vector<ListNode*>& lists) {
		priority_queue<ListNode*, vector<ListNode*>, compare> min_heap;
		for (int i = 0; i < lists.size(); i++) {
			if (lists[i] != nullptr) {
				min_heap.push(lists[i]);
			}
		}
		ListNode dummy(0);
		ListNode* tail = &dummy;
		while (min_heap.size() > 0) {
			ListNode* cur = min_heap.top();
			min_heap.pop();
			tail->next = new ListNode(cur->val);
			tail = tail->next;
			if (cur->next != nullptr) {
				min_heap.push(cur->next);
			}
		}
		return dummy.next;
	}
private:
	struct compare {
		bool operator()(const ListNode* l1, const ListNode* l2) {
			return l1->val > l2->val;
		}
	};
};
