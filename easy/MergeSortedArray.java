public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        int indx = 0, i = 0, j = 0, start = m, end = n;
        for (indx = 0,i = 0, j = 0; indx < m+n && j < n; indx++) {
            if (start != end) {
                if (nums1[start] <= nums2[j]) {

                }
                else {
                    nums1
                }
            }
            else {
                if (nums1[i] <= nums2[j]) {
                    i++;
                }
                else {
                    add(nums1, start, end, nums1[indx]);
                    nums1[indx] = nums2[j];
                    j++;
                }
            }
        }

        for (; j < n ; j++) {
            nums1[indx++] = nums2[j];
        }
        */
        int indx = m+n-1, i = m -1, j = n-1;
        for (; i >= 0 && j >=0 && indx >= 0 ; indx--) {
            if (nums1[i]>nums2[j]) {
                nums1[indx] = nums1[i];
                i--;
            }
            else {
                nums1[indx] = nums2[j];
                j--;
            }
        }

        for (; j >= 0; j--) {
            nums1[indx--] = nums2[j];
        }

    }
}
