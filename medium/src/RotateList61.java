public class RotateList61 {
    public static void main(String[] args) {

        RotateList61 obj = new RotateList61();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head != null && head.next != null) {
            int len = 0;
            ListNode temp = head;
            while (temp != null) {
                len += 1;
                temp = temp.next;
            }
            k = k % len;
            if (k > 0) {
                temp = head;
                ListNode end = head;
                int count = 0;
                while (temp.next != null) {
                    count += 1;
                    if (count == len-k) {
                        end = temp;
                    }
                    temp = temp.next;
                }
                temp.next = head;
                head = end.next;
                end.next = null;
            }
        }
        return head;
    }
}
