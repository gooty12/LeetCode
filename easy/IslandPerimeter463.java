public class IslandPerimeter463 {
    // DFS
    public int islandPerimeter(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int u = -1, v = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visit[i][j] = false;
                if (grid[i][j] == 1) {
                    u = i;
                    v = j;
                }
            }
        }
        int res = 0;
        if (u != -1) {
            res = dfs(u, v, visit, grid);
        }
        return res;
    }

    public int dfs(int u, int v, boolean[][] visit, int[][] grid) {
        int p = 0;
        if (!visit[u][v]) {
            visit[u][v] = true;
            p += dfshelper(u+1, v, visit, grid);
            p += dfshelper(u, v+1, visit, grid);
            p += dfshelper(u-1, v, visit, grid);
            p += dfshelper(u, v-1, visit, grid);
        }
        return p;
    }

    public int dfshelper(int u, int v, boolean[][] visit, int[][] grid) {
        int p = 0;
        if(u >= 0 && u < grid.length && v >= 0 && v < grid[0].length) {
            if (grid[u][v]==0) {
                p += 1;
            }
            else if (grid[u][v]==1 && !visit[u][v]) {
                p += dfs(u, v, visit, grid);
            }
        }
        else {
            p = 1;
        }
        return p;
    }

    // Efficient and simple
    public int islandPerimeter2(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    res -= adjacency(i,j, grid);
                }
            }
        }
        return res;
    }

    public int adjacency(int u, int v, int[][] grid) {
        int p = 0;
        p += adjacencyhelper(u+1, v, grid);
        p += adjacencyhelper(u, v+1, grid);
        p += adjacencyhelper(u-1, v, grid);
        p += adjacencyhelper(u, v-1, grid);
        return p;
    }

    public int adjacencyhelper(int u, int v, int[][] grid) {
        int p = 0;
        if(u >= 0 && u < grid.length && v >= 0 && v < grid[0].length) {
            if (grid[u][v]==1) {
                p = 1;
            }
        }
        return p;
    }
}
