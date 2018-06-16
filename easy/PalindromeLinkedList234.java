public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        boolean res = true;
        ListNode temp = head;
        while (temp != null) {
            n += 1;
            temp = temp.next;
        }

        if (n > 1) {
            temp = head;
            for(int i = 1; i < n/2; i++) {
                temp = temp.next;
            }
            ListNode head2 = temp.next;
            temp.next = null;
            head2 = n%2 == 1 ? head2.next : head2;
            head = reverse(head);
            res = true;
            while (res && head != null) {
                res = head.val == head2.val;
                head = head.next;
                head2 = head2.next;
            }
        }

        return res;
    }

    public boolean isPalindrome2(ListNode head) {
        boolean res = true;
        if (head == null || head.next == null) {
            res = true;
        }
        else {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            slow = fast == null ? slow : slow.next;
            ListNode head2 = reverse(slow);
            ListNode head1 = head;
            res = true;
            while (res && head2 != null) {
                res = head1.val == head2.val;
                head1 = head1.next;
                head2 = head2.next;
            }
        }

        return res;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
