public class RemoveDuplicatesFromList82 {
    public static void main(String[] args) {

        RemoveDuplicatesFromList82 obj = new RemoveDuplicatesFromList82();
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp1 = head;
        ListNode prev = dummy;
        while(temp1 != null) {
            ListNode temp2 = temp1;
            while(temp2 != null && temp2.val == temp1.val) {
                temp2 = temp2.next;
            }
            if (temp1.next == temp2) {
                prev.next = temp1;
                prev = temp1;
                temp1 = temp2;
            }
            else {
                prev.next = temp2;
                temp1 = temp2;
            }
        }
        return dummy.next;
    }
}
