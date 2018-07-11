import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {

        Subsets78 obj = new Subsets78();
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums != null && nums.length > 0) {
            int n = nums.length;
            for (int m = 0; m < 1<<n; m++) {
                List<Integer> l = new ArrayList<>();
                for (int mask = 1<<n-1, i = 0; i < n; i++, mask>>>=1) {
                    if ((mask & m) > 0) {
                        l.add(nums[i]);
                    }
                }
                res.add(l);
            }
        }
        return res;
    }
}
