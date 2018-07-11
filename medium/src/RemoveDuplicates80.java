public class RemoveDuplicates80 {
    public static void main(String[] args) {

        RemoveDuplicates80 obj = new RemoveDuplicates80();
        obj.removeDuplicates(new int[]{1,1,1,2,2,3});
    }

    public int removeDuplicates(int[] nums) {
        int indx = 0;
        for (int i = 0; i < nums.length; ) {
            int count = 0;
            int elem = nums[i];
            for (; i < nums.length && nums[i]==elem; i++, count++);
            count = count>=2 ? 2 : count;
            nums[indx++] = elem;
            if (count > 1) {
                nums[indx++] = elem;
            }
        }
        return indx;
    }
}
