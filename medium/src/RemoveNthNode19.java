public class RemoveNthNode19 {
    public static void main(String[] args) {

        RemoveNthNode19 obj = new RemoveNthNode19();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        if (head != null) {
            ListNode temp = head;
            for (int i = 0; i < n; i++) {
                temp = temp.next;
            }

            ListNode temp2 = dummy;
            while (temp != null) {
                temp = temp.next;
                temp2 = temp2.next;
            }
            temp2.next = temp2.next == null ? null : temp2.next.next;
        }
        return dummy.next;
    }
}
