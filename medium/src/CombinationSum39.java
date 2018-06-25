import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {

        CombinationSum39 obj = new CombinationSum39();
    }

    public List<List<Integer>> recurse(int[] candidates, int target, int index) {
        List<List<Integer>> res = new ArrayList<>();
        if (target != 0 ) {
            int v = candidates[index];
            for (int n = 0; n*v <= target; n++) {
                List<Integer> l = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    l.add(v);
                }
                if (n*v == target) {
                    res.add(l);
                }
                else {
                    if (index+1 < candidates.length) {
                        List<List<Integer>> res2 = recurse(candidates, target-n*v, index+1);
                        for (List<Integer> ll : res2) {
                            ll.addAll(l);
                            res.add(ll);
                        }
                    }
                }
            }
        }
        return res;
    }

    // dfs is easy to implement
    List<List<Integer>> res = new ArrayList<>();
    public void dfs(List<Integer> ls, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(ls);
        }
        else if (index < candidates.length) {
            int v = candidates[index];
            for (int n = 0; n*v <= target; n++) {
                List<Integer> nls = new ArrayList<>(ls);
                for (int i = 0; i < n; i++) {
                    nls.add(v);
                }
                dfs(nls, candidates, target-n*v, index+1);
            }
        }
    }
}
