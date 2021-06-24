class Partition {
public:
	ListNode* partition(ListNode* head, int x) {
        ListNode smaller(0);
        ListNode larger(0);
        ListNode *smaller_tail = &smaller, *larger_tail = &larger;
        while (head) {
            if (head->val < x) {
                smaller_tail->next = head;
                smaller_tail = smaller_tail->next;
            } else {
                larger_tail->next = head;
                larger_tail = larger_tail->next;
            }
            head = head->next;
        }
        larger_tail->next = nullptr;
        smaller_tail->next = larger.next;
        return smaller.next;
    }
};
