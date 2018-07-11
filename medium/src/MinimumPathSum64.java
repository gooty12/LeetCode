public class MinimumPathSum64 {
    public static void main(String[] args) {

        MinimumPathSum64 obj = new MinimumPathSum64();
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int res = 0;
        if (m > 0) {
            int n = grid[0].length;
            if (n > 0) {
                for (int i = m-1; i >= 0; i--) {
                    for (int j = n-1; j >= 0; j--) {
                        int a = i < m-1 ? grid[i+1][j] : Integer.MAX_VALUE;
                        int b = j < n-1 ? grid[i][j+1] : Integer.MAX_VALUE;
                        if (i != m-1 || j != n-1) {
                            grid[i][j] += Math.min(a, b);
                        }
                    }
                }
                res = grid[0][0];
            }
        }
        return res;
    }
}
