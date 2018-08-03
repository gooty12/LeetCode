public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {

        ValidateBinarySearchTree98 obj = new ValidateBinarySearchTree98();
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long min, long max) {
        boolean res = true;
        if (root != null) {
            res = root.val > min && root.val < max;
            res = res && isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
        }
        return res;
    }
}
