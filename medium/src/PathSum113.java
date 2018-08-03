import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum113 {
    public static void main(String[] args) {

        PathSum113 obj = new PathSum113();
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recurse(root, 0, sum, new LinkedList<Integer>());
        return res;
    }

    public void recurse(TreeNode root, int sum, int target, LinkedList<Integer> l) {
        if (root != null) {
            sum += root.val;
            l.addLast(root.val);
            if (root.left == null && root.right == null) {
                if (sum == target) {
                    res.add(new ArrayList(l));
                }
            }
            else {
                recurse(root.left, sum, target, l);
                recurse(root.right, sum, target, l);
            }
            l.removeLast();
        }
        return;
    }
}
