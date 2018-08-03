import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointerTwo117 {
    public static void main(String[] args) {

        NextRightPointerTwo117 obj = new NextRightPointerTwo117();
    }

    public void connect(TreeLinkNode root) {
        //recurse(root, null, false);
        if (root != null) {
            Queue<TreeLinkNode> q = new LinkedList<>();
            q.offer(root);
            q.offer(null);
            while (!q.isEmpty()) {
                boolean hasNext = false;
                while (q.peek() != null) {
                    TreeLinkNode node = q.poll();
                    node.next = q.peek();
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                    hasNext = hasNext || node.left != null || node.right != null;
                }
                q.poll();
                if (hasNext) {
                    q.offer(null);
                }
            }
        }
    }

    public void recurse(TreeLinkNode root, TreeLinkNode parent, boolean isLeft) {
        if (root != null) {
            if (isLeft) {
                root.next = parent.right;
            }

            TreeLinkNode temp = parent==null ? null : parent.next;
            while (root.next==null && temp != null) {
                root.next = temp.left==null? temp.right : temp.left;
                temp = temp.next;
            }

            recurse(root.left, root, true);
            recurse(root.right, root, false);
        }
    }
}
