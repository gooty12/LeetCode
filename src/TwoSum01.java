import java.util.HashMap;
import java.util.Map;

public class TwoSum01 {
    public int[] twoSum(int[] nums, int target) {
        Integer index1 = null, index2 = null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            index1 = map.get(target - nums[i]);
            if (index1 != null) {
                index2 = i;
                break;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[]{index1, index2};
    }
}
