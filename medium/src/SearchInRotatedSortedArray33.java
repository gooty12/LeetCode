public class SearchInRotatedSortedArray33 {
    public static void main(String[] args) {

        SearchInRotatedSortedArray33 obj = new SearchInRotatedSortedArray33();
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                res = mid;
                break;
            }
            if (mid == start) {
                res = nums[end] == target ? end : -1;
                break;
            }
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return res;
    }











}
