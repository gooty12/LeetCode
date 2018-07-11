public class ScoreAfterFlippingMatrix861 {
    public static void main(String[] args) {

        ScoreAfterFlippingMatrix861 obj = new ScoreAfterFlippingMatrix861();
    }

    public int matrixScore(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = 1-A[i][j];
                }
            }
        }
        int p = (int)Math.pow(2, A[0].length-1);
        for (int i = 0; i < A[0].length; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                count += A[j][i];
            }
            res += p * Math.max(count, A.length-count);
            p /= 2;
        }
        return res;
    }
}
