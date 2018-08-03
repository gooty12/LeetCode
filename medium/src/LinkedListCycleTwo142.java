public class LinkedListCycleTwo142 {
    public static void main(String[] args) {

        LinkedListCycleTwo142 obj = new LinkedListCycleTwo142();
    }

    public ListNode detectCycle(ListNode head) {
        ListNode res = null;
        ListNode first = head, second = head;
        while (second != null) {
            first = first.next;
            second = second.next == null ? null : second.next.next;
            if (first == second) {
                break;
            }
        }

        if (second != null && first == second) {
            for (ListNode temp = head; res == null; temp = temp.next) {
                first = second.next;
                while (first != temp && first != second) {
                    first = first.next;
                }
                res = first == temp ? temp : null;
            }
        }
        return res;
    }
}
