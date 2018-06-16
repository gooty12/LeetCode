import java.util.ArrayList;
import java.util.List;

public class BinaryWatch401 {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h <= 11; h++) {
            int n1 = Integer.bitCount(h);
            if (n1 <= num) {
                for (int min = 0; min <= 59; min++) {
                    int n2 = Integer.bitCount(min);
                    if (n1 + n2 == num) {
                        String m = min < 10 ? "0"+min : "" + min;
                        res.add(h + ":" + m);
                    }
                }
            }
        }
        return res;
    }
}
