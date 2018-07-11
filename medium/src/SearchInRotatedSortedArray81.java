import java.util.Arrays;

public class SearchInRotatedSortedArray81 {
    public static void main(String[] args) {

        SearchInRotatedSortedArray81 obj = new SearchInRotatedSortedArray81();
    }

    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        boolean res = false;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                res = true;
                break;
            }
            else if (start == end) {
                break;
            }
            else {
                if (nums[start]==nums[mid] || nums[mid]==nums[end]) {
                    res = search(Arrays.copyOfRange(nums, start, Math.max(start+1, mid)), target) ||
                            search(Arrays.copyOfRange(nums, mid+1, end+1), target);
                    break;
                }
                else if (nums[start] < nums[mid]) {
                    if (nums[start] <= target && target < nums[mid]) {
                        end = mid-1;
                    }
                    else {
                        start = mid+1;
                    }
                }
                else {
                    if (nums[mid] < target && target <= nums[end]) {
                        start = mid+1;
                    }
                    else {
                        end = mid - 1;
                    }

                }
            }
        }
        return res;
    }
}
