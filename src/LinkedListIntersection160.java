public class LinkedListIntersection160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;

        ListNode t1 = headA;
        while (t1 != null) {
            len1 += 1;
            t1 = t1.next;
        }

        ListNode t2 = headB;
        while (t2 != null) {
            len2 += 1;
            t2 = t2.next;
        }

        t1 = headA;
        t2 = headB;
        if (len1 > len2) {
            for (int i = 0; i < len1-len2; i++) {
                t1 = t1.next;
            }
        }
        else if (len2 > len1) {
            for (int i = 0; i < len2-len1; i++) {
                t2 = t2.next;
            }
        }

        ListNode res = null;
        while (res==null && t1 != null && t2 != null) {
            res = t1==t2 ? t1 : null;
            t1 = t1.next;
            t2 = t2.next;
        }

        return res;
    }
}
