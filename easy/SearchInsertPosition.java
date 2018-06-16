public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        if (nums.length == 0) {
            index = 0;
        }
        else {
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                int mid = start + (end - start)/2;
                if (target == nums[mid]) {
                    start = end = mid;
                    break;
                }
                else if (target < nums[mid]) {
                    end = Math.max(start, mid-1);
                }
                else {
                    start = Math.min(mid+1, end);
                }
            }

            if (target == nums[start]) {
                index = start;
            }
            else if (target < nums[start]) {
                index = start;
            }
            else {
                index = start + 1;
            }
        }

        return index;
    }
}
