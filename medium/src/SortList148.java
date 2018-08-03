public class SortList148 {
    public static void main(String[] args) {

        SortList148 obj = new SortList148();
    }

    public ListNode sortList(ListNode head) {
        ListNode res = head;
        if (head != null && head.next != null) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = dummy, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next == null ? null : fast.next.next;
            }
            ListNode h2 = slow.next;
            slow.next = null;
            h2 = sortList(h2);
            ListNode h1 = sortList(head);
            res = merge(h1, h2);
        }
        return res;
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for (; h1 != null && h2 != null; ) {
            if (h1.val <= h2.val) {
                ListNode t2 = h1.next;
                temp.next = h1;
                temp.next.next = null;;
                temp = h1;
                h1 = t2;
            }
            else {
                ListNode t2 = h2.next;
                temp.next = h2;
                temp.next.next = null;
                temp = h2;
                h2 = t2;
            }
        }

        temp.next = h1 == null ? h2 : h1;
        return dummy.next;
    }
}
