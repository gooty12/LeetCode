import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int n = (nums.length+1) / 2;
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int i : nums) {
            int count = map.merge(i, 1, (old, newVal) -> old + newVal);
            if (count >= n) {
                res = i;
                break;
            }
        }

        return res;
    }
}
