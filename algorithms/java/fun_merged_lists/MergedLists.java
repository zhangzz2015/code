class MergedLists {
	public boolean checkListsJoin(ListNode a, ListNode b) {
		if (a == null && b == null) {
			return true;
		} else if (a == null || b == null) {
			return false;
		}
		ListNode aTail = getTail(a);
		ListNode bTail = getTail(b);
		if (aTail.next == null && bTail.next == null) {
			// neither list have cycle
			return aTail == bTail;
		} else if (aTail.next != null && bTail.next != null) {
			// both lists have cycle
			return isSameCycle(aTail, bTail);
		} else {
			// one has cycle and the other one does not
			return false;
		}
	}
	// if no cycle return tail, else return some node in the cycle
	private ListNode getTail(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return slow;
			}
		}
		return fast.next == null ? fast : fast.next;
	}
	private boolean isSameCycle(ListNode a, ListNode b) {
		ListNode cur = a.next;
		while (cur != a) {
			if (cur == b) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}
}
