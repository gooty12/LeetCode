import java.util.ArrayList;
import java.util.List;

public class SortedToBST109 {
    public static void main(String[] args) {

        SortedToBST109 obj = new SortedToBST109();
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        List<Integer> l = new ArrayList<>();
        while(temp != null) {
            l.add(temp.val);
            temp = temp.next;
        }
        return recurse(l, 0, l.size()-1);
    }

    public TreeNode recurse(List<Integer> l, int st, int end) {
        TreeNode root = null;
        if (st <= end) {
            int mid = st + (end-st)/2;
            root = new TreeNode(l.get(mid));
            root.left = recurse(l, st, mid-1);
            root.right = recurse(l, mid+1, end);
        }
        return root;
    }
}
