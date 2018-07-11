public class WordSearch79 {
    public static void main(String[] args) {

        WordSearch79 obj = new WordSearch79();
    }

    boolean[][] visit;
    public boolean exist(char[][] board, String word) {
        boolean res = true;
        if (!word.isEmpty()) {
            if (board.length == 0) {
                res = false;
            }
            else {
                int n= word.length();
                res = false;
                visit = new boolean[board.length][board[0].length];
                for (int i = 0; !res && i < board.length; i++) {
                    for (int j = 0; !res && j < board[0].length; j++) {
                        if (board[i][j] == word.charAt(0)) {
                            visit[i][j] = true;
                            res = search(board, word, i, j, 1);
                            visit[i][j] = false;
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean search(char[][] board, String word, int rw, int col, int next) {
        boolean res = false;
        if (next == word.length()) {
            res = true;
        }
        else {
            char ch = word.charAt(next);
            for (int i = -1; !res && i <= 1; i++) {
                for (int j = -1; !res && j <= 1; j++) {
                    if (i==0 && j==0) {
                        continue;
                    }
                    else if ((i==0 || j==0) && rw+i>=0 && rw+i<board.length && col+j>=0 && col+j<board[0].length &&
                            !visit[rw+i][col+j] && board[rw+i][col+j]==ch) {
                        visit[rw][col] = true;
                        res = search(board, word, rw+i, col+j, next+1);
                        visit[rw][col] = false;
                    }
                }
            }
        }
        return res;
    }
}
