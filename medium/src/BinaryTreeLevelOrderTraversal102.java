import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversal102 obj = new BinaryTreeLevelOrderTraversal102();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<TreeNode>> nodes = new ArrayList<>();
        if (root != null) {
            boolean hasNext = true;
            res.add(Arrays.asList(root.val));
            nodes.add(Arrays.asList(root));
            while (hasNext) {
                List<Integer> l = new ArrayList<>();
                List<TreeNode> nList = new ArrayList<>();
                for (TreeNode node : nodes.get(nodes.size()-1)) {
                    if (node.left != null) {
                        nList.add(node.left);
                        l.add(node.left.val);
                    }
                    if (node.right != null) {
                        nList.add(node.right);
                        l.add(node.right.val);
                    }
                }
                if (!nList.isEmpty()) {
                    nodes.add(nList);
                    res.add(l);
                }
                hasNext = !nList.isEmpty();
            }
        }
        return res;
    }
}
