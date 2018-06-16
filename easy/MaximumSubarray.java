public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums.length > 0 ? nums[0] : 0;
        int currSum = sum;
        for (int i = 1; i < nums.length; i++) {
            if (currSum > 0) {
                currSum += nums[i];
            }
            else {
                currSum = nums[i];
            }
            sum = Math.max(sum, currSum);
        }

        return sum;
    }

    /* nice attempt
    public  int maxSubArrayDivideConquer(int[] nums, int start, int end, int[] indices, boolean takeLeft) {
        int sum = 0;
        indices[0] = -1;
        indices[1] = -1;
        if (start == end) {
            sum = nums[start];
            indices[0] = start;
            indices[1] = end;
        }
        else {
            int mid = start + (end - start)/2;
            int sum1 = maxSubArrayDivideConquer(nums, start, mid, indices, false);
            int start1 = indices[0];
            int end1 = indices[1];

            int sum2 = maxSubArrayDivideConquer(nums, Math.min(mid+1, end), end, indices, true);
            int start2 = indices[0];
            int end2 = indices[1];

            if (start2 == end1 + 1 && sum1 >= 0 && sum2 >= 0) {
                sum = sum1 + sum2;
                indices[0] = start1;
                indices[1] = end2;
            }
            else if (sum1 == sum2) {
                sum = takeLeft ? sum1 : sum2;
                indices[0] = takeLeft ? start1 : start2;
                indices[1] = takeLeft ? end1 : end2;
            }
            else if (sum1 > sum2){
                sum = sum1;
                indices[0] = start1;
                indices[1] = end1;
            }
            else {
                sum = sum2;
                indices[0] = start2;
                indices[1] = end2;
            }
        }

        return sum;
    }
    */

    public  int maxSubArrayDivideConquer(int[] nums, int start, int end) {
        int sum = 0;

        if (start == end) {
            sum = nums[start];
        }
        else {
            int mid = start + (end - start)/2;
            int sum1 = maxSubArrayDivideConquer(nums, start, mid);
            int sum2 = maxSubArrayDivideConquer(nums, Math.min(mid+1, end), end);

            int sum3 = nums[mid];
            int combinedSum = nums[mid];
            int currSum = nums[mid];
            for (int i = mid-1; i >= start ; i--) {
                currSum += nums[i];
                sum3 = Math.max(sum3, currSum);
            }
            combinedSum = sum3;
            sum3 = nums[mid];
            currSum = nums[mid];
            for (int i = mid+1; i <= end; i++) {
                currSum += nums[i];
                sum3 = Math.max(sum3, currSum);
            }
            combinedSum += sum3 - nums[mid];

            sum = Math.max(Math.max(sum1, sum2), combinedSum);
        }

        return sum;
    }
}
