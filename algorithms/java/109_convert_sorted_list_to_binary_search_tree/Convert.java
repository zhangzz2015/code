public class Convert {
    
    // 2. recursion
    public TreeNode sortedListToBST(ListNode head) {
        return construct(head);
    }
    private TreeNode construct(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode mid = findMid(head);
        ListNode cur = mid.next;
        ListNode right = cur.next;
        mid.next = null;
        cur.next = null;
        TreeNode root = new TreeNode(head.val);
        root.left = construct(head);
        root.right = construct(right);
        return root;
    }
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode prev = null;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    // 3. use a global pointer to inorder traverse linkedlist pointing to the root
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;
        int len = getLength(head);
        ListNode[] cur = new ListNode[]{head};
        return construct(0, len - 1, cur);
    }
    private TreeNode construct(int start, int end, ListNode[] cur) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = construct(start, mid - 1, cur);
        TreeNode root = new TreeNode (cur[0].val);
        cur[0] = cur[0].next;
        root.right = construct(mid + 1, end, cur);
        root.left = left;
        return root;
    }
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
