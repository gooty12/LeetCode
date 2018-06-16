import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root != null) {
            if (root.left == null && root.right == null) {
                res.add("" + root.val);
            }
            else {
                res.addAll(binaryTreePaths(root.left));
                res.addAll(binaryTreePaths(root.right));
                res = res.stream().map(s -> ""+root.val+"->"+s).collect(Collectors.toList());
            }
        }
        return res;
    }
}
