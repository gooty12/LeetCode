import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public static void main(String[] args) {

        Combinations77 obj = new Combinations77();
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n >= k) {
            if (k == 0) {
                res.add(new ArrayList<>());
            }
            else {
                res = combine(n-1, k-1);
                for (List<Integer> l : res) {
                    l.add(n);
                }
                res.addAll(combine(n-1, k));
            }
        }
        return res;
    }
}
