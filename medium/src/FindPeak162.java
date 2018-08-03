public class FindPeak162 {
    public static void main(String[] args) {

        FindPeak162 obj = new FindPeak162();
    }

    public int findPeakElement(int[] nums) {
        return recurse(nums, 0, nums.length-1);
    }

    public int recurse(int[] nums, int st, int end) {
        int res = -1;
        if (st <= end) {
            int mid = st + (end-st)/2;
            long left = mid-1>=0 ? nums[mid-1] : Long.MIN_VALUE;
            long right = mid+1 < nums.length ? nums[mid+1] : Long.MIN_VALUE;
            res = left < nums[mid] && right < nums[mid] ? mid : -1;
            if (res == -1) {
                // right
                res = recurse(nums, mid+1, end);
                res = res==-1 ? recurse(nums, st, mid-1) : res;
            }
        }
        return res;
    }
}
