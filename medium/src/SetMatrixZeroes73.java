public class SetMatrixZeroes73 {
    public static void main(String[] args) {

        SetMatrixZeroes73 obj = new SetMatrixZeroes73();
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            if (n > 0) {
                boolean rowZero = false;
                boolean colZero = false;

                for (int i = 0; !rowZero && i < n; i++) {
                    rowZero = matrix[0][i] == 0;
                }

                for (int i = 0; !colZero && i < m; i++) {
                    colZero = matrix[i][0] == 0;
                }

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == 0) {
                            matrix[i][0] = 0;
                            matrix[0][j] = 0;
                        }
                    }
                }

                for (int i = 1; i < m; i++) {
                    if (matrix[i][0] == 0) {
                        setRowZero(i, matrix);
                    }
                }

                for (int j = 1; j < n; j++) {
                    if (matrix[0][j] == 0) {
                        setColumnZero(j, matrix);
                    }
                }

                if (rowZero) {
                    setRowZero(0, matrix);
                }

                if (colZero) {
                    setColumnZero(0, matrix);
                }

            }
        }
    }

    public void setRowZero(int r, int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[r][j] = 0;
        }
    }

    public void setColumnZero(int col, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
