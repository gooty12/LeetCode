import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static void main(String[] args) {

        SpiralMatrix54 obj = new SpiralMatrix54();
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length > 0) {
            int r1 = 0, c1 = 0;
            int r2 = matrix.length-1, c2 = matrix[0].length-1;
            while (r1<=r2 && c1<=c2) {
                for (int i = c1; i <= c2; i++) {
                    res.add(matrix[r1][i]);
                }
                for (int i = r1+1; i < r2; i++) {
                    res.add(matrix[i][c2]);
                }
                for (int i = c2; r1 != r2 && i >= c1; i--) {
                    res.add(matrix[r2][i]);
                }
                for (int i = r2-1; c1 != c2 && i > r1; i--) {
                    res.add(matrix[i][c1]);
                }
                r1 += 1; r2 -= 1;
                c1 += 1; c2 -= 1;
            }
        }
        return res;
    }
}
