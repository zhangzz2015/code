class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int length = getLength(head);
        for (int i = 1; i < (length - k%length); i++) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;        
    }
    private int getLength(ListNode head) {
        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        cur.next = head;
        return count;
    }
}
