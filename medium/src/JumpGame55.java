public class JumpGame55 {
    public static void main(String[] args) {

        JumpGame55 obj = new JumpGame55();
    }

    public boolean canJump(int[] nums) {
        // 0 -> not processed, 1 -> possible 2 -> not possible
        int[] possible = new int[nums.length];
        possible[nums.length-1] = 1;
        return recurse(nums, possible, 0);
    }

    public boolean recurse(int[] nums, int[] possible, int indx) {
        boolean res = false;
        if (possible[indx] != 0) {
            res = possible[indx]==1 ? true : false;
        }
        else {
            int step = nums[indx];
            possible[indx] = 2;
            for (int i = 1; res = false && i <= step && indx+i < nums.length; i++) {
                res = recurse(nums, possible, indx+i);
                possible[i] = res ? 1 : 2;
            }
        }
        return res;
    }

    public boolean canJump2(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length-1] = true;
        for (int i = nums.length-2; i >= 0; i--) {
            for (int j = 1; !dp[i] && j <= nums[i] && i+j < nums.length; j++) {
                dp[i] = dp[i+j];
            }
        }
        return dp[0];
    }
}
