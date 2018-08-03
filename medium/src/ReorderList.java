public class ReorderList {
    public static void main(String[] args) {

        ReorderList obj = new ReorderList();
    }

    public void reorderList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode fast = head, slow = null;
            while (fast != null && fast.next != null) {
                slow = slow == null ? head : slow.next;
                fast = fast.next == null ? null : fast.next.next;
            }
            //reverse
            slow = fast == null ? slow : slow.next;
            ListNode prev = null;
            ListNode curr = slow.next;
            slow.next = null;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr  = temp;
            }

            ListNode dummy = new ListNode(0);
            ListNode h1 = head;
            ListNode h2 = prev;
            ListNode temp = dummy;
            while (h2 != null) {
                temp.next = h1;
                h1 = h1.next;
                temp.next.next = h2;
                temp = h2;
                h2 = h2.next;
                temp.next = null;
            }
            if (h1 != null) {
                temp.next = h1;
            }
        }
    }
}
