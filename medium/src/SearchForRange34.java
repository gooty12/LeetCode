public class SearchForRange34 {
    public static void main(String[] args) {

        SearchForRange34 obj = new SearchForRange34();
    }

    public int[] searchRange(int[] nums, int target) {
        int res1 = -1;
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid]==target) {
                res1 = mid;
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        int res2 = -1;
        if (res1 != -1)  {
            start = 0;
            end = nums.length-1;
            while (start <= end) {
                int mid = start + (end-start)/2;
                if (nums[mid]==target) {
                    res2 = mid;
                    start = mid + 1;
                }
                else if (nums[mid] < target) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return new int[] {res1, res2};
    }
}
