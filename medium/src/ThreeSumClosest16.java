import java.util.Arrays;

public class ThreeSumClosest16 {
    public static void main(String[] args) {

        ThreeSumClosest16 obj = new ThreeSumClosest16();
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long res = 111111111111L;
        for (int i = 0; res != target && i < nums.length; i++) {
            int j = i+1, k = nums.length-1;
            while (j < k) {
                long sum = nums[i] + nums[j] + nums[k];
                long dist1 = Math.abs(res - target);
                long dist2 = Math.abs(sum - target);
                res = dist2 < dist1 ? sum : res;
                if (sum == target) {
                    break;
                }
                else if (sum > target) {
                    k -= 1;
                }
                else {
                    j += 1;
                }
            }
        }

        return (int)res;
    }
}
