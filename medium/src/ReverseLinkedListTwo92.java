public class ReverseLinkedListTwo92 {
    public static void main(String[] args) {

        ReverseLinkedListTwo92 obj = new ReverseLinkedListTwo92();
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy1 = new ListNode(-1);
        dummy1.next = head;
        if (head != null) {
            int count = 0;
            ListNode temp = dummy1;
            while (count < m-1) {
                temp = temp.next;
                count += 1;
            }
            int N = n-m+1;
            ListNode dummy2 = new ListNode(-1);
            ListNode curr = temp.next, h2 = temp.next;
            temp.next = null;
            ListNode prev = dummy2;
            count = 1;
            while (count <= N) {
                ListNode temp2 = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp2;
                count += 1;
            }
            //
            temp.next = prev;
            h2.next = curr;

        }
        return dummy1.next;
    }
}
