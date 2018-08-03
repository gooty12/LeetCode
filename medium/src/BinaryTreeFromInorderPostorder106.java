import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderPostorder106 {
    public static void main(String[] args) {

        BinaryTreeFromInorderPostorder106 obj = new BinaryTreeFromInorderPostorder106();
    }

    Map<Integer, Integer> map = new HashMap<>();
    int indx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        indx = postorder.length - 1;
        return recurse(inorder, postorder, 0, inorder.length-1);
    }

    public TreeNode recurse(int[] inorder, int[] postorder, int st, int end) {
        TreeNode root = null;
        if (indx>=0 && st<=end) {
            int elem = postorder[indx--];
            root = new TreeNode(elem);
            root.right = recurse(inorder, postorder, map.get(elem)+1, end);
            root.left = recurse(inorder, postorder, st, map.get(elem)-1);
        }
        return root;
    }
}
