import java.util.Arrays;

public class RangeQuerySum303 {
    int[] dp;
    public RangeQuerySum303(int[] nums) {
        dp = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j]-dp[i-1];
    }
}
