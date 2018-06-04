public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        ListNode temp1 = head;
        if (temp1 != null) {
            ListNode temp2 = temp1.next;
            temp1.next = null;
            while (temp2 != null) {
                ListNode temp3 = temp2.next;
                temp2.next = temp1;
                temp1 = temp2;
                temp2 = temp3;
            }
        }
        return temp1;
    }

    public ListNode reverseListSimple(ListNode head) {
        ListNode prev = null;
        if (head != null) {
            ListNode curr = head;
            while (curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
        }
        return prev;
    }
}
