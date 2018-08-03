import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightView199 {
    public static void main(String[] args) {

        BinaryTreeRightView199 obj = new BinaryTreeRightView199();
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            q.offer(null);
            while (!q.isEmpty()) {
                boolean hasNext = false;
                TreeNode prev = null;
                while (true) {
                    TreeNode u = q.poll();
                    if (u == null) {
                        res.add(prev.val);
                        break;
                    }
                    else {
                        prev = u;
                        if (u.left != null) {
                            q.offer(u.left);
                            hasNext = true;
                        }
                        if (u.right != null) {
                            q.offer(u.right);
                            hasNext = true;
                        }
                    }
                }
                if (hasNext) {
                    q.offer(null);
                }
            }
        }

        return res;
    }
}
