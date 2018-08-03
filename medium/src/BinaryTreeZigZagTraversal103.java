import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigZagTraversal103 {
    public static void main(String[] args) {

        BinaryTreeZigZagTraversal103 obj = new BinaryTreeZigZagTraversal103();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<TreeNode>> nodes = new ArrayList<>();
        if (root != null) {
            boolean hasNext = true, reverse = true;
            res.add(Arrays.asList(root.val));
            nodes.add(Arrays.asList(root));
            while (hasNext) {
                LinkedList<Integer> l = new LinkedList<>();
                List<TreeNode> nList = new ArrayList<>();
                for (TreeNode node : nodes.get(nodes.size()-1)) {
                    if (node.left != null) {
                        nList.add(node.left);
                        if (reverse) {
                            l.addFirst(node.left.val);
                        }
                        else {
                            l.addLast(node.left.val);
                        }
                    }
                    if (node.right != null) {
                        nList.add(node.right);
                        if (reverse) {
                            l.addFirst(node.right.val);
                        }
                        else {
                            l.addLast(node.right.val);
                        }
                    }
                }
                if (!nList.isEmpty()) {
                    nodes.add(nList);
                    res.add(l);
                }
                hasNext = !nList.isEmpty();
                reverse = !reverse;
            }
        }
        return res;
    }
}
