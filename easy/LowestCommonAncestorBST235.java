public class LowestCommonAncestorBST235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        if (root != null) {
            if (root.val == p.val || root.val == q.val) {
                res = root;
            }
            else {
                int val = 0;
                val = recur(root.left, p.val, q.val);
                if (val == p.val+q.val) {
                    res = lowestCommonAncestor(root.left, p, q);
                }
                else if (val == p.val || val == q.val) {
                    res = root;
                }
                else {
                    res = lowestCommonAncestor(root.right, p, q);
                }
            }
        }
        return res;
    }

    public int recur(TreeNode root, int a, int b) {
        int res = 0;
        if (root != null) {
            if (root.val == a || root.val == b) {
                res += root.val;
            }
            res = res + recur(root.left, a, b) + recur(root.right, a, b);
        }
        return res;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        if (root != null) {
            if (root.val < Math.min(p.val, q.val)) {
                res = lowestCommonAncestor2(root.right, p, q);
            }
            else if (root.val > Math.max(p.val, q.val)) {
                res = lowestCommonAncestor2(root.left, p, q);
            }
            else {
                res = root;
            }
        }
        return res;
    }
}
