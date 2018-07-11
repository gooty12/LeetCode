public class SortColors75 {
    public static void main(String[] args) {

        SortColors75 obj = new SortColors75();
    }

    public void sortColors(int[] nums) {
        int i = -1;
        int j = nums.length;
        for (int k = i+1; k < j; k++) {
            if (k != i+1 && nums[k] == 0) {
                nums[k] = nums[i+1];
                nums[i+1] = 0;
                i++; k--;
            }
            if (nums[k] == 2 && k != j-1) {
                nums[k] = nums[j-1];
                nums[j-1] = 2;
                k--; j--;
            }
        }
    }
}
