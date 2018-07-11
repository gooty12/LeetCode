import java.util.ArrayList;
import java.util.List;

public class GrayCode89 {
    public static void main(String[] args) {

        GrayCode89 obj = new GrayCode89();
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int N = (int)Math.pow(2, n);
        boolean[] used = new boolean[N];
        res.add(0);
        used[0] = true;
        for (int i = 1; i<N; i++) {
            int num = res.get(res.size()-1);
            boolean f = false;
            for (int j = 0; !f && j < n; j++) {
                int m = (int)Math.pow(2, j);
                int bit = m & num;
                int val = 0;
                if(bit == 0) {
                    val = num + m;
                }
                else {
                    val = num - m;
                }
                if (val >= 0 && val < N && !used[val]) {
                    res.add(val);
                    f = true;
                    used[val] = true;
                }
            }
        }
        return res;
    }
}
