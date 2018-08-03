import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderPreorder105 {
    public static void main(String[] args) {

        BinaryTreeFromInorderPreorder105 obj = new BinaryTreeFromInorderPreorder105();
    }

    Map<Integer, Integer> map;
    int indx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recurse(preorder, inorder, 0, inorder.length-1);
    }

    public TreeNode recurse(int[] preorder, int[] inorder, int st, int end) {
        TreeNode res = null;
        if (indx < preorder.length && st<=end) {
            int elem = preorder[indx++];
            res = new TreeNode(elem);
            res.left = recurse(preorder, inorder, st, map.get(elem)-1);
            res.right = recurse(preorder, inorder, map.get(elem)+1, end);
        }
        return res;
    }
}
