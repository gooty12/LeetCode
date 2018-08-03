public class SmallestSubTreeWithAllDeepestNodes865 {
    public static void main(String[] args) {

        SmallestSubTreeWithAllDeepestNodes865 obj = new SmallestSubTreeWithAllDeepestNodes865();
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        TreeNode res = null;
        if (root != null) {
            int maxDepth = getMaxDepth(root);
            res = getTree(root, 0, maxDepth);
        }
        return res;
    }

    // return recurse(root, -1).node;
    public Node recurse(TreeNode root, int dpth) {
        Node res = null;
        if (root == null) {
            res = new Node(dpth, null);
        }
        else {
            Node left = recurse(root.left, dpth+1);
            Node right = recurse(root.right, dpth+1);
            int d1 = left.maxDepth, d2 = right.maxDepth;
            res = d1==d2 ? new Node(d1, root) : (d1 < d2 ? right : left);
        }
        return res;
    }

    public int getMaxDepth(TreeNode root) {
        int res = 0;
        if (root != null) {
            res = 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
        }
        return res;
    }

    public TreeNode getTree(TreeNode root, int d, int max) {
        TreeNode res = null;
        if (root != null) {
            if (d == max-1) {
                res = root;
            }
            else {
                TreeNode left = getTree(root.left, d+1, max);
                TreeNode right = getTree(root.right, d+1, max);
                if (left == null) {
                    res = right;
                }
                else if (right == null) {
                    res = left;
                }
                else {
                    res = root;
                }
            }
        }
        return res;
    }
}

class Node {
    public int maxDepth;
    public TreeNode node;
    public Node(int d, TreeNode node) {
        maxDepth = d;
        this.node = node;
    }
}