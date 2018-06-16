import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> src = Collections.singletonList(1);
        for (; rowIndex > 0; rowIndex--) {
            List<Integer> dst = new ArrayList<>();
            dst.add(1);
            for (int i = 0; i < src.size()-1; i++) {
                dst.add(src.get(i) + src.get(i+1));
            }
            dst.add(1);
            src = dst;
        }

        return src;
    }
}
