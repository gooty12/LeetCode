public class SwapNodes24 {
    public static void main(String[] args) {

        SwapNodes24 obj = new SwapNodes24();
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode t1 = head;
        ListNode prev = dummy;
        while (t1 != null && t1.next != null) {
            ListNode t2 = t1.next;
            ListNode t3 = t2.next;
            prev.next = t2;
            t2.next = t1;
            t1.next = t3;
            prev = t1;
            t1 = t3;
        }
        return dummy.next;
    }
}
