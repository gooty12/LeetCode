class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}

public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        do {
            if (p1!=null) {
                p1 = p1.next;
                if(p2.next!=null) {
                    p2 = p2.next.next;
                }
                else {
                    p2 = null;
                }
            }
        } while (p1!=null && p2!=null && p1!=p2);

        if (p1==null || p2==null) {
            return false;
        }
        else {
            return p1==p2;
        }
    }
}
