import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsTwo47 {
    public static void main(String[] args) {

        PermutationsTwo47 obj = new PermutationsTwo47();
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length > 0) {
            Arrays.sort(nums);
            recurse(new boolean[nums.length], nums, new ArrayList<>(), 0);
        }
        return res;
    }

    public void recurse(boolean[] used, int[] nums, List<Integer> perm, int ind) {
        if (ind >= nums.length) {
            res.add(perm);
        }
        else {
            long prev = Long.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (!used[i] && nums[i] != prev) {
                    int n = nums[i];
                    used[i] = true;
                    List<Integer> newPerm = new ArrayList<>(perm);
                    newPerm.add(n);
                    recurse(used, nums, newPerm, ind+1);
                    used[i] = false;
                    prev = n;
                }
            }
        }

    }
}
