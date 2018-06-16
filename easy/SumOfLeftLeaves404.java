public class SumOfLeftLeaves404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeftLeavesHelper(root, false);
    }

    public int sumLeftLeavesHelper(TreeNode root, boolean isLeft) {
        int res;
        if (root == null) {
            res = 0;
        }
        else if (root.left == null && root.right == null) {
            res = isLeft ? root.val : 0;
        }
        else {
            res = sumLeftLeavesHelper(root.left, true) + sumLeftLeavesHelper(root.right, false);
        }
        return res;
    }
}
