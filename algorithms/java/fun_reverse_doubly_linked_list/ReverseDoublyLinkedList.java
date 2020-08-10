public class ReverseDoublyLinkedList {
    static class ListNode {
        int val;
        ListNode prev;
        ListNode next;
    }
    
    // using previious node
    public ListNode reverseDoublyLinkedList1(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = cur.prev;
            cur.prev = next;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // if we do not use prev node
    public ListNode reverseDoublyLinkedList2(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = cur.prev;
            cur.prev = next;
            if (next == null) {
                return cur;
            }
            cur = next;
        }
        return null;
    }
}