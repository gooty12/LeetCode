public class FlattenBinaryToLinkedList {
    public static void main(String[] args) {

        FlattenBinaryToLinkedList obj = new FlattenBinaryToLinkedList();
    }

    public void flatten(TreeNode root) {
        recurse(root);
    }

    public TreeNode recurse(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right = null;
            root.left = null;
            root.right = recurse(left);
            TreeNode temp = root;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = recurse(right);
        }
        return root;
    }
}
