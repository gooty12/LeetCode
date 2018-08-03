import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToAllkeys865 {
    public static void main(String[] args) {

        ShortestPathToAllkeys865 obj = new ShortestPathToAllkeys865();
        obj.shortestPathAllKeys2(new String[]{"@.a.#","###.#","b.A.B"});
    }

    public int shortestPathAllKeys2(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int res = -1;
        int k = 0;
        int start = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    start = i*n + j;
                }
                else if (ch >= 'a' && ch <= 'z') {
                    k += 1;
                }
            }
        }

        // bfs
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[m*n][1<<k];
        visited[start][0] = true;
        int K = (1<<k) - 1;
        q.offer(new Node(start, 0, 0));
        while (!q.isEmpty()) {

            Node node = q.poll();
            if (node.keys == K) {
                res = node.dist;
                break;
            }

            int x = node.pos / n, y = node.pos % n;
            int[] adj = new int[]{1, 0, -1, 0, 1};

            for (int i = 0; i < adj.length-1; i++) {
                int x1 = x+adj[i], y1 = y+adj[i+1];
                int p1 = x1*n + y1;
                if (x1>=0 && x1<m && y1>=0 && y1<n && grid[x1].charAt(y1) != '#') {
                    char ch = grid[x1].charAt(y1);
                    int k1 = node.keys;
                    if (ch != '.' && ch != '@') {
                        boolean upper = Character.isUpperCase(ch);
                        int off =  upper ? ch - 'A' : ch - 'a';
                        if (upper && ((node.keys & 1<<off) == 0)) {
                            continue;
                        }
                        if (!upper && ((node.keys & 1<<off) == 0)) {
                            k1 += 1<<off;
                        }
                    }
                    if (!visited[p1][k1]) {
                        visited[p1][k1] = true;
                        q.offer(new Node(p1, k1,node.dist+1));
                    }
                }
            }

        }//while

        return res;
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

class Node {
    int pos;
    int keys;
    int dist;
    public Node(int pos, int keys, int dist) {
        this.pos = pos;
        this.keys = keys;
        this.dist = dist;
    }
}
