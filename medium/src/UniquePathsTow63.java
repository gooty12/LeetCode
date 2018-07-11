public class UniquePathsTow63 {
    public static void main(String[] args) {

        UniquePathsTow63 obj = new UniquePathsTow63();
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int res = 0;
        if (m > 0) {
            int n = obstacleGrid[0].length;
            if (n > 0) {
                int[][] dp = new int[m][n];
                dp[m-1][n-1] = 1 - obstacleGrid[m-1][n-1];
                for (int i = m-1; i >= 0; i--) {
                    for (int j = n-1; j >= 0; j--) {
                        if (obstacleGrid[i][j] != 1) {
                            dp[i][j] += i < m-1 ? dp[i+1][j] : 0;
                            dp[i][j] += j < n-1 ? dp[i][j+1] : 0;
                        }
                    }
                }
                res = dp[0][0];
            }
        }
        return res;
    }
}
