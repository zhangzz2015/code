class SwapNodes {
	// iterative
	public ListNode swap1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		while (head != null && head.next != null) {
			ListNode next = head.next.next;
			prev.next = head.next;
			head.next.next = head;
			head.next = next;
			prev = head;
			head = next;
		}
		return dummy.next;
	}

	// recursive
	public ListNode swap2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		head.next = swap2(head.next.next);
		next.next = head;
		return next;
	}
}
