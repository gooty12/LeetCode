import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal144 {
    public static void main(String[] args) {

        PreorderTraversal144 obj = new PreorderTraversal144();
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        q.push(root);
        while (!q.isEmpty()) {
            TreeNode node = q.pop();
            if (node != null) {
                res.add(node.val);
                q.push(node.right);
                q.push(node.left);
            }
        }
        return res;
    }
}
