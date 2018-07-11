import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTwo90 {
    public static void main(String[] args) {

        SubsetsTwo90 obj = new SubsetsTwo90();
    }

    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        recurse(nums, 0, new ArrayList<Integer>());
        return res;
    }

    public void recurse(int[] nums, int ind, List<Integer> l) {
        if (ind >= nums.length) {
            res.add(new ArrayList<Integer>(l));
        }
        else {
            int count = 0;
            for (int i = ind; i < nums.length && nums[i]==nums[ind]; i++, count++);
            int sz = l.size();
            for (int n = 0; n <= count; n++) {
                if (n > 0) {
                    l.add(nums[ind]);
                }
                recurse(nums, ind+count, l);
            }
            l.subList(sz, l.size()).clear();
        }
    }
}
