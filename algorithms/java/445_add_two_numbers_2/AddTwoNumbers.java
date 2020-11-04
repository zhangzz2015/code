class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		Deque<ListNode> stack1 = addToStack(l1);
		Deque<ListNode> stack2 = addToStack(l2);
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int carry = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int val1 = stack1.isEmpty() ? 0 : stack1.pop().val;
			int val2 = stack2.isEmpty() ? 0 : stack2.pop().val;
			int sum = val1 + val2 + carry;
			cur.next = new ListNode(sum % 10);
			carry = sum / 10;
			cur = cur.next;
		}
		if (carry != 0) {
			cur.next = new ListNode(carry);
		}
		return reverse(dummy.next);
	}
	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	private Deque<ListNode> addToStack(ListNode head) {
		Deque<ListNode> stack = new LinkedList<>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		return stack;
	}
}
