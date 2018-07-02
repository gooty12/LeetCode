public class UniquePaths62 {
    public static void main(String[] args) {

        UniquePaths62 obj = new UniquePaths62();
    }

    public int uniquePaths(int m, int n) {
        int ans = 0;
        if (m > 0 && n > 0) {
            int[][] dp = new int[m][n];
            dp[m-1][n-1] = 1;
            for (int i = m-1; i >= 0; i--) {
                for (int j = n-1; j >= 0; j--) {
                    dp[i][j] += i<m-1 ? dp[i+1][j] : 0;
                    dp[i][j] += j<n-1 ? dp[i][j+1] : 0;
                }
            }
            ans = dp[0][0];
        }
        return ans;
    }
}
