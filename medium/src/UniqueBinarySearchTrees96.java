import java.util.Arrays;

public class UniqueBinarySearchTrees96 {
    public static void main(String[] args) {

        UniqueBinarySearchTrees96 obj = new UniqueBinarySearchTrees96();
    }

    public int numTrees(int n) {
        int res = 0;
        if (n > 0) {
            int[][] dp = new int[n+1][n];
            Arrays.fill(dp[0], 1);
            for (int l = 1; l <= n; l++) {
                for (int st = 0; st+l <= n; st++) {
                    for (int i = st; i < st + l; i++) {
                        int len1 = i-st;
                        int len2 = l-len1-1;
                        int lft = len1 > 0 ? dp[len1][st] : 1;
                        int rgt = len2 > 0 ? dp[len2][i+1] : 1;
                        dp[l][st] += lft * rgt;

                    }
                }
            }
            res = dp[n][0];
        }
        return res;
    }

    public int numTrees2(int n) {
        int res = 0;
        if (n > 0) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            for (int i = 1; i <=n; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j]*dp[i-j-1];
                }
            }
            res = dp[n];
        }
        return res;
    }
}
