public class MinimumInRotatedSortedArray153 {
    public static void main(String[] args) {

        MinimumInRotatedSortedArray153 obj = new MinimumInRotatedSortedArray153();
    }

    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        int st = 0;
        int end = nums.length - 1;
        while (st <= end) {
            int mid = st + (end-st)/2;
            if (nums[st] < nums[mid]) {
                res = Math.min(res, nums[st]);
                st = mid+1;
            }
            else if (st == mid) {
                res = Math.min(Math.min(res, nums[st]), nums[end]);
                break;
            }
            else {
                res = Math.min(res, nums[mid]);
                end = mid - 1;
            }
        }
        return res;
    }
}
