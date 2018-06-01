import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        if (numRows >= 1) {
            res.add(Collections.singletonList(1));
            numRows--;
        }
        for (; numRows > 0; numRows--) {
            List<Integer> l1 = res.get(res.size()-1);
            List<Integer> l2 = new ArrayList<Integer>();
            l2.add(1);
            for (int i = 0; i < l1.size()-1; i++) {
                l2.add(l1.get(i) + l1.get(i+1));
            }
            l2.add(1);
            res.add(l2);
        }
        return res;
    }
}
