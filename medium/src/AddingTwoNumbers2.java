class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
 }

public class AddingTwoNumbers2 {
    public static void main(String[] args) {

        AddingTwoNumbers2 obj = new AddingTwoNumbers2();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        int carry = 0;
        ListNode temp1 = l1, temp2 = l2, temp = res;;
        while (temp1 != null || temp2 != null) {
            int v1 = 0, v2 = 0;
            if (temp1 != null) {
                v1 = temp1.val;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                v2 = temp2.val;
                temp2 = temp2.next;
            }
            int sum = v1 + v2 + carry;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            carry = sum/10;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry);
        }
        return res.next;
    }
}
