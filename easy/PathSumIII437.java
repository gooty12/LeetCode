public class PathSumIII437 {
    public static void main(String[] args) {

        PathSumIII437 obj = new PathSumIII437();
    }

    public int pathSum(TreeNode root, int sum) {
        int res = 0;
        if (root != null) {
            res = pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }
        return res;
    }

    public int pathSumFrom(TreeNode node, int sum) {
        int res = 0;
        if (node != null) {
            res = node.val==sum ? 1 : 0;
            res += pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
        }
        return res;
    }
}
