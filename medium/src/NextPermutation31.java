public class NextPermutation31 {
    public static void main(String[] args) {

        NextPermutation31 obj = new NextPermutation31();
    }

    public void nextPermutation(int[] nums) {

        if (nums.length > 1) {
            int i = nums.length-2;
            for (; i >= 0 && nums[i] >= nums[i+1]; i--);
            int start = i+1;
            int end = nums.length-1;
            while (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start += 1;
                end -= 1;
            }
            if (i >= 0) {
                int j = i+1;
                for (; j < nums.length && nums[i] >= nums[j]; j++);
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
