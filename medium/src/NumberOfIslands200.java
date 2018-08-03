public class NumberOfIslands200 {
    public static void main(String[] args) {

        NumberOfIslands200 obj = new NumberOfIslands200();
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = m>0 ? grid[0].length : 0;
        if (m > 0 && n > 0) {
            boolean[][] visit = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && grid[i][j] == '1') {
                        res += 1;
                        dfs(i, j, visit, grid);
                    }
                }
            }
        }
        return res;
    }

    private void dfs(int rw, int col, boolean[][]  visit, char[][] grid) {
        int m = visit.length, n = visit[0].length;
        if (rw >= 0 && rw < m && col >= 0 && col < n && !visit[rw][col] && grid[rw][col] == '1') {
            visit[rw][col] = true;
            dfs(rw+1, col, visit, grid);
            dfs(rw-1, col, visit, grid);
            dfs(rw, col+1, visit, grid);
            dfs(rw, col-1, visit, grid);
        }
    }
}
