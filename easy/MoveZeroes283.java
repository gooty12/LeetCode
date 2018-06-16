public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count] =  nums[i];
                if (count != i) {
                    nums[i] = 0;
                }
                count++;
            }
        }
    }
}
