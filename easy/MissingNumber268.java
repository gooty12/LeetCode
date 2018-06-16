import java.util.Arrays;

public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        return ((n*(n+1))/2) - sum;
    }
}
