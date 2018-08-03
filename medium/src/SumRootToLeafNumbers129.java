public class SumRootToLeafNumbers129 {
    public static void main(String[] args) {

        SumRootToLeafNumbers129 obj = new SumRootToLeafNumbers129();
    }

    int total;
    public int sumNumbers(TreeNode root) {
        recurse(root, 0);
        return total;
    }

    public void recurse(TreeNode root, int sum) {
        if (root != null) {
            sum = sum*10 + root.val;
            if (root.left == null && root.right == null) {
                total += sum;
            }
            else {
                recurse(root.left, sum);
                recurse(root.right, sum);
            }
        }
    }
}
