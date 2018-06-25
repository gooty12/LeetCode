import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    public static void main(String[] args) {

        FourSum18 obj = new FourSum18();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                for (int j = i+1; j < nums.length; j++) {
                    if (j == i+1 || nums[j] != nums[j-1]) {
                        int p = j+1, q = nums.length-1;
                        while (p < q) {
                            int sum = nums[i] + nums[j] + nums[p] + nums[q];
                            if (sum == target) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                                for (p = p+1; p < q && nums[p] == nums[p-1]; p++);
                                for (q = q-1; q > p && nums[q] == nums[q+1]; q--);
                            }
                            else if (sum > target) {
                                q -= 1;
                            }
                            else {
                                p += 1;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
