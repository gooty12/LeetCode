public class SpiralMatrixTwo59 {
    public static void main(String[] args) {

        SpiralMatrixTwo59 obj = new SpiralMatrixTwo59();
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int r1 = 0, r2 = n-1;
        int c1 =0, c2 = n-1;
        int num = 1;
        int N = n*n;
        while (r1 <= r2) {
            for (int i = c1; num <= N && i <= c2; i++) {
                res[r1][i] = num;
                num += 1;
            }
            for (int i = r1+1; num <= N && i < r2; i++) {
                res[i][c2] = num;
                num += 1;
            }
            for (int i = c2; num <= N && i >= c1; i--) {
                res[r2][i] = num;
                num += 1;
            }
            for (int i = r2-1; num <= N && i > r1; i--) {
                res[i][c1] = num;
                num += 1;
            }
            r1 += 1; c1 += 1;
            r2 -= 1; c2 -= 1;
        }
        return res;
    }
}
