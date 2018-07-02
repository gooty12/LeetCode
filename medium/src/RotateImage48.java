public class RotateImage48 {
    public static void main(String[] args) {

        RotateImage48 obj = new RotateImage48();
    }

    public void rotate(int[][] matrix) {
        int r1,r2,c1,c2;
        r1 = 0;
        r2 = matrix.length-1;
        c1 = 0;
        c2 = matrix.length-1;
        while (r1 < r2) {
            int cols = c2-c1+1;
            for (int i = 0; i < cols-1; i++) {
                swap(r1, c1+i, r1+i, c2, matrix);
                swap(r2-i, c1, r2, c2-i, matrix);
                swap(r1, c1+i, r2, c2-i, matrix);
            }
            r1 += 1;
            r2 -= 1;
            c1 += 1;
            c2 -= 1;
        }
    }

    public void swap(int i, int j, int p, int q, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = temp;
    }
}
