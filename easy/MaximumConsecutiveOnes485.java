public class MaximumConsecutiveOnes485 {
    public static void main(String[] args) {

        MaximumConsecutiveOnes485 obj = new MaximumConsecutiveOnes485();
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        for (int i = 0, n = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res = Math.max(res, n);
                n = 0;
            }
            else {
                n += 1;
            }
            if (i == nums.length-1) {
                res = Math.max(res, n);
            }
        }
        return res;
    }
}
