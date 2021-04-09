class Reverse {
	// iterative
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;
		while (cur != null) {
			ListNode kNode = getK(cur, k);
			if (kNode == null) {
				return dummy.next;
			}
			ListNode next = kNode.next;
			kNode.next = null;
			prev.next = reverse(cur);
			cur.next = next;
			prev = cur;
			cur = next;
		}
		return dummy.next;
	}
	private ListNode getK(ListNode cur, int k) {
		while (cur != null && k > 1) {
			cur = cur.next;
			k--;
		}
		return cur;
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

	// recursion
	public ListNode reverseK(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		int count = 0;
		while (cur != null && count < k) {
			count++;
			cur = cur.next;
		}
		if (count < k) {
			return head;
		}
		cur = reverseK(cur, k);
		while (count-- > 0) {
			// cur is prev, tmp is next
			ListNode tmp = head.next;
			head.next = cur;
			cur = head;
			head = tmp;
		}
	}
}
