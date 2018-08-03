class TreeLinkNode {
    TreeLinkNode left, right, next;
    int val;
    public TreeLinkNode(int val) {
        this.val = val;
    }
}
public class NextRightPointers116 {
    public static void main(String[] args) {

        NextRightPointers116 obj = new NextRightPointers116();
    }

    public void connect(TreeLinkNode root) {
        recurse(root, null, false);
    }

    public void recurse(TreeLinkNode root, TreeLinkNode parent, boolean isLeft) {
        if (root != null) {
            if (isLeft) {
                root.next = parent.right;
            }
            else {
                root.next = ((parent == null || parent.next == null) ? null : parent.next.left);
            }
            recurse(root.left, root, true);
            recurse(root.right, root, false);
        }
    }
}
