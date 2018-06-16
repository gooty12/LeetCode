import java.util.Arrays;

public class ContainsDuplicates217 {
    public boolean containsDuplicate(int[] nums) {
        //nums = Arrays.stream(nums).sorted().toArray();
        boolean res = false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                res = true;
                break;
            }
        }
        return res;
    }
}
