public class MinimumRefuelingStops871 {
    public static void main(String[] args) {

        MinimumRefuelingStops871 obj = new MinimumRefuelingStops871();
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n+1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int t = i; t >= 0 && dp[t] >= stations[i][0]; t--) {
                dp[t+1] = Math.max(dp[t+1], dp[t] + stations[i][1]);
            }
        }
        int res  = -1;
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                res = i;
                break;
            }
        }
        return res;
    }
}

