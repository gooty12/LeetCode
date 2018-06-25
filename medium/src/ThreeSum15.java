import java.util.*;

public class ThreeSum15 {
    public static void main(String[] args) {

        ThreeSum15 obj = new ThreeSum15();
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i==0 || nums[i] != nums[i-1]) {
                for (int j = i+1; j < nums.length; j++) {
                    if (j==i+1 || (nums[j] != nums[j-1])) {
                        int c = -(nums[i]+nums[j]);
                        Integer ind = map.get(c);
                        if (ind != null && ind > j) {
                            res.add(Arrays.asList(nums[i], nums[j], c));
                        }
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            int j = i+1, k = nums.length-1;
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while (j < nums.length && j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i],  nums[j], nums[k]));
                    for (j = j+1; j < nums.length && (nums[j] == nums[j-1]); j++);
                    for (k = k-1; k>=0 && (nums[k] == nums[k+1]); k--);
                }
                else if (sum > 0) {
                    k -= 1;
                }
                else {
                    j += 1;
                }
            }
        }
        return res;
    }
}
