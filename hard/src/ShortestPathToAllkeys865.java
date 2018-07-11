public class ShortestPathToAllkeys865 {
    public static void main(String[] args) {

        ShortestPathToAllkeys865 obj = new ShortestPathToAllkeys865();
    }

    public int shortestPathAllKeys(String[] grid) {
        int keys = 0;
        int moves = 0;
        if (grid.length > 0) {
            if (grid[0].length() > 0) {
                int r = 0, c = 0;
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length(); j++) {
                        char ch = grid[i].charAt(j);
                        if (ch == '@') {
                            r = i;
                            c = j;
                        }
                        else {
                            int asc = ch;
                            if (asc >= 'a' && asc <= 'z') {
                                keys = Math.max(keys, asc-'a'+1);
                            }
                        }
                    }
                }
                int[][][] dp = new int[grid.length][grid[0].length()][64];
                // fill all [][][0]s to 0;
                boolean[][][] visit = new boolean[grid.length][grid[0].length()][64];
                moves = recurse(grid, r, c, (int)Math.pow(2, keys)-1, visit);
            }
        }
        return moves==Integer.MAX_VALUE? -1 : moves;
    }

    public int recurse(String[] grid, int rw, int cl, int keys, boolean[][][] visit) {
        int moves = 0;
        if (rw < 0 || rw >= grid.length || cl < 0 || cl >= grid[0].length()) {
            moves = Integer.MAX_VALUE;
        }
        else if (visit[rw][cl][keys]) {
            moves = Integer.MAX_VALUE;
        }
        else  {

        }
        return moves;
    }
}
