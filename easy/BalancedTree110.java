public class BalancedTree110 {
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root)==-1 ? false : true;
    }

    public int isBalancedHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            int depth1 = isBalancedHelper(root.left);
            if (depth1 == -1) {
                return -1;
            }
            else {
                int depth2 = isBalancedHelper(root.right);
                return (depth2==-1 || Math.abs(depth1-depth2)>1) ? -1 : 1+Math.max(depth1, depth2);
            }
        }
    }
}
