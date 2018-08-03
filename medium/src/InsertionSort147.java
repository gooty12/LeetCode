public class InsertionSort147 {
    public static void main(String[] args) {

        InsertionSort147 obj = new InsertionSort147();
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode t = dummy;
        while (t != null && t.next != null) {
            int val = t.next.val;
            ListNode p = dummy;
            for (; p.next != t.next && p.next.val <= val; p = p.next);
            if (p.next != t.next) {
                ListNode temp = t.next;
                t.next = t.next.next;
                temp.next = p.next;
                p.next = temp;
            }
            else {
                t = t.next;
            }
        }
        return dummy.next;
    }
}
