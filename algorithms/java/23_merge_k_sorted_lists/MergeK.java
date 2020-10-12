class MergeK {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
		for (ListNode node : lists) {
			if (node != null) {
				minHeap.offer(node);
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (!minHeap.isEmpty()) {
			ListNode min = minHeap.poll();
			cur.next = min;
			cur = cur.next;
			if (min.next != null) {
				minHeap.offer(min.next);
			}
		}
		return dummy.next;
	}
}
