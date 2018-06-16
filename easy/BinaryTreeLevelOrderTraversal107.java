import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root != null) {
            List<Integer> l = new ArrayList<>();
            q.add(root);
            q.add(null);
            boolean hasChild = false;
            while(!q.isEmpty()) {
                TreeNode node = q.remove();
                if (node == null) {
                    ((LinkedList<List<Integer>>)res).addFirst(l);
                    //res.add(l);
                    l = new ArrayList<>();
                    if(hasChild) {
                        q.add(null);
                    }
                    hasChild = false;
                }
                else {
                    l.add(node.val);
                    if (node.left != null) {
                        q.add(node.left);
                        hasChild = true;
                    }
                    if (node.right != null) {
                        q.add(node.right);
                        hasChild = true;
                    }
                }
            }
        }

        return res;
    }
}
