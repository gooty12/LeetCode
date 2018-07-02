import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo40 {
    public static void main(String[] args) {

        CombinationSumTwo40 obj = new CombinationSumTwo40();
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = null;
        if (candidates != null) {
            Arrays.sort(candidates);
            res = recurse(candidates, 0, target);
        }
        return res;
    }

    public List<List<Integer>> recurse(int[] candidates, int indx, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target != 0) {
            int count = 0;
            int v = candidates[indx];
            for (int i = indx; i < candidates.length && candidates[i]==candidates[indx]; i++, count++);
            for (int n=0; n <= count && n*v <= target; n++) {
                List<Integer> l = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    l.add(v);
                }
                if (n*v == target) {
                    res.add(l);
                }
                else if (indx + count < candidates.length) {
                    List<List<Integer>> res2 = recurse(candidates, indx+count, target-n*v);
                    for (List<Integer> ll : res2) {
                        ll.addAll(l);
                        res.add(ll);
                    }
                }
            }
        }
        return res;
    }
}
