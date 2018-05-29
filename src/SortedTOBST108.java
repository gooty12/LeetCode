public class SortedTOBST108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        else {
            return sortedArrayToBSTHelper(nums, 0, nums.length-1);
        }
    }

    public TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
        TreeNode bst = null;
        if (start > end) {
            return null;
        }
        else if (start == end) {
            bst = new TreeNode(nums[start]);
            bst.left = bst.right = null;
        }
        else {
            int mid = start + (end-start+1)/2;
            bst = new TreeNode(nums[mid]);
            bst.left = sortedArrayToBSTHelper(nums, start, mid-1);
            bst.right = sortedArrayToBSTHelper(nums, mid+1, end);
        }

        return bst;
    }
}
