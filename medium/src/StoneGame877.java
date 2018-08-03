public class StoneGame877 {
    public static void main(String[] args) {

        StoneGame877 obj = new StoneGame877();
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp1 = new int[n][n], dp2 = new int[n][n];
        dp1[n-1][n-1] = dp2[n-1][n-1] = piles[n-1];
        for (int i = n-2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                //dp1[i][j] => piles[i]  or piles[j]
                int c1 = piles[i] + (i+1 < n ? dp2[i+1][j] : 0);
                int c2 = piles[j] + (j-1 >= 0 ? dp2[i][j-1] : 0);
                dp1[i][j] = Math.max(c1, c2);

                c1 = piles[i] + (i+1 < n ? dp1[i+1][j] : 0);
                c2 = piles[j] + (j-1 >= 0 ? dp1[i][j-1] : 0);
                dp2[i][j] = Math.max(c1, c2);
            }
        }
        int sum = 0;
        for (int p : piles) {
            sum += p;
        }
        return dp1[0][n-1] > sum - dp1[0][n-1];
    }
}
