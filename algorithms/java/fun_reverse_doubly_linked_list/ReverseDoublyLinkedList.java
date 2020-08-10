public class ReverseDoublyLinkedList {
    static class ListNode {
        int val;
        ListNode prev;
        ListNode next;
    }
    
    public ListNode reverseDoublyLinkedList(ListNode head) {
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
}