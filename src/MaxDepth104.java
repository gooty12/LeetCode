public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            res = 0;
        }
        else {
            res = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        return res;
    }
}
