import java.util.Deque;
import java.util.LinkedList;


public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        else {
            return areSymmetric(root.left, root.right);
        }
    }

    public boolean areSymmetric(TreeNode left, TreeNode right) {
        if (left==null && right==null) {
            return true;
        }
        else if(left==null ||right==null) {
            return false;
        }
        else {
            return left.val==right.val && areSymmetric(left.left, right.right) && areSymmetric(left.right, right.left);
        }
    }

    public boolean isSymmetricIterative(TreeNode root) {
        boolean res = true;
        if (root == null) {
            res = true;
        }
        else {
            Deque<TreeNode> stack1 = new LinkedList<>();
            Deque<TreeNode> stack2 = new LinkedList<>();
            stack1.push(root.left);
            stack2.push(root.right);
            res = true;
            while (res && !stack1.isEmpty()) {
                TreeNode node1 = stack1.pop();
                TreeNode node2 = stack2.pop();
                if (node1==null && node2==null) {
                    res = true;
                }
                else if(node1==null || node2==null) {
                    res = false;
                }
                else {
                    res = node1.val==node2.val;
                    if (res) {
                        stack1.push(node1.left);
                        stack2.push(node2.right);

                        stack1.push(node1.right);
                        stack2.push(node2.left);
                    }
                }
            }
        }
        return res;
    }
}
