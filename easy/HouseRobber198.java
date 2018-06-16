public class HouseRobber198 {
    public int rob(int[] nums) {
        int res = 0;
        if (nums.length > 0) {
            int[] dp = new int[nums.length];
            dp[nums.length-1] = nums[nums.length-1];
            res = Math.max(dp[nums.length-1], res);
            for (int i = nums.length-2; i >= 0; i--) {
                dp[i] = Math.max(dp[i+1], nums[i] + (i+2 <= nums.length-1 ? dp[i+2] : 0));
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
