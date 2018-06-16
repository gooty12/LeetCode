import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs447 {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            long x1 = points[i][0], y1 = points[i][1];
            Map<Long, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    long x2 = points[j][0], y2 = points[j][1];
                    long d = (long)(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
                    int count = map.merge(d, 1, (ol, nw) -> ol + nw);
                    res += (count-1)*2;
                }
            }
        }
        return res;
    }

    // Brute force
    public int numberOfBoomerangs2(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            double x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    double x2 = points[j][0], y2 = points[j][1];
                    double d1 = Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2);
                    for (int k = j+1; k < points.length; k++) {
                        if (k != i && k != j) {
                            double x4 = points[k][0], y4 = points[k][1];
                            double d2 = Math.pow(x4-x1, 2) + Math.pow(y4-y1, 2);
                            if (d1 == d2) {
                                res += 2;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
