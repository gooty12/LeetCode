import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
    public static void main(String[] args) {

        BinaryTreeInorderTraversal94 obj = new BinaryTreeInorderTraversal94();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Boolean> processed = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        stack.push(root);
        processed.push(false);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            boolean b = processed.pop();
            if (node != null) {
                if (b) {
                    res.add(node.val);
                }
                else {
                    stack.push(node.right);
                    processed.push(false);

                    stack.push(node);
                    processed.push(true);

                    stack.push(node.left);
                    processed.push(false);
                }
            }
        }

        return res;
    }
}
