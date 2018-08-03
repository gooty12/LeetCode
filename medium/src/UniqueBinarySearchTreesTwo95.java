import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesTwo95 {
    public static void main(String[] args) {

        UniqueBinarySearchTreesTwo95 obj = new UniqueBinarySearchTreesTwo95();
    }

    public List<TreeNode> generateTrees(int n) {
        return recurse(1, n);
    }

    public List<TreeNode> recurse(int st, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (st <= end) {
            for (int i = st; i <= end; i++) {
                List<TreeNode> left = recurse(st, i-1);
                List<TreeNode> right = recurse(i+1, end);
                if (left.isEmpty()){
                    left.add(null);
                }
                if (right.isEmpty()) {
                    right.add(null);
                }
                for (TreeNode l : left) {
                    for (TreeNode r: right) {
                        /*
                        TreeNode l2 = l==null ? null : new TreeNode(l.val);
                        r = r==null ? r : new TreeNode(r.val);
                        */
                        TreeNode node = new TreeNode(i);
                        node.left = l;
                        node.right = r;
                        res.add(node);
                    }
                }
            }
        }
        return res;
    }
}
