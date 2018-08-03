import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer138 {
    public static void main(String[] args) {

        CopyListWithRandomPointer138 obj = new CopyListWithRandomPointer138();
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode temp1 = head, temp2 = dummy;;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (temp1 != null) {
            RandomListNode node = new RandomListNode(temp1.label);
            map.put(temp1, node);
            temp1 = temp1.next;
            temp2.next = node;
            temp2 = node;
        }

        temp1 = head;
        temp2 = dummy.next;
        while (temp1 != null) {
            temp2.random = map.get(temp1.random) ;
            temp2 = temp2.next;
            temp1 = temp1.next;
        }

        return dummy.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    public RandomListNode(int label) {
        this.label = label;
    }
}
