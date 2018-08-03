public class MaximumProductSubarray152 {
    public static void main(String[] args) {

        MaximumProductSubarray152 obj = new MaximumProductSubarray152();
    }

    public int maxProduct(int[] nums) {
        long maxm = -1;
        long minm = 1;
        long res = nums[0];
        for (int n : nums) {
            if (n == 0) {
                maxm = minm = 0;
            }
            else if (maxm == 0) {
                maxm = n > 0 ? n : -1;
                minm = n < 0 ? n : 1;
            }
            else if (n > 0) {
                maxm = maxm > 0 ? maxm*n : n;
                minm = minm < 0 ? n*minm : 1;
            }
            else {
                long tmax = minm < 0 ? n * minm : -1;
                long tmin = maxm > 0 ? n * maxm : n;
                maxm = tmax;
                minm = tmin;
            }
            res = maxm >= 0 ? Math.max(maxm, res) : Math.max(res, minm);
        }
        return (int)res;
    }
}
