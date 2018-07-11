public class PartitionList86 {
    public static void main(String[] args) {

        PartitionList86 obj = new PartitionList86();
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode t1 = dummy1, t2 = dummy2;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                t1.next = new ListNode(temp.val);
                t1 = t1.next;
            }
            else {
                t2.next = new ListNode(temp.val);
                t2 = t2.next;
            }
            temp = temp.next;
        }

        ListNode res = null;
        if(dummy1.next == null || dummy2.next == null ) {
            res = head;
        }
        else {
            t1.next = dummy2.next;
            res = dummy1.next;
        }
        return res;
    }
}
