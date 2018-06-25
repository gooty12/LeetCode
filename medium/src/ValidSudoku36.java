public class ValidSudoku36 {
    public static void main(String[] args) {

        ValidSudoku36 obj = new ValidSudoku36();
    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] sq = new boolean[9][9];
        boolean res = true;
        for (int i = 0; res && i < 9; i++) {
            if (i%3 == 0) {
                for (int k = 0; k < 3; k++) {
                    sq[k] = new boolean[9];
                }
            }
            for (int j = 0; res && j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int n = ch - '1';
                    if (rows[i][n] || cols[j][n] || sq[j/3][n]) {
                        res = false;
                    }
                    else {
                        rows[i][n] = cols[j][n] = sq[j/3][n] = true;
                    }
                }
            }
        }
        return res;
    }
}
