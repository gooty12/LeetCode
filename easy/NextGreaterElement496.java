import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement496 {
    public static void main(String[] args) {

        NextGreaterElement496 obj = new NextGreaterElement496();
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Integer j = map.get(nums1[i]);
            for (j = j+1; j < nums2.length && nums2[j] <= nums1[i]; j++);
            res[i] = j==nums2.length? -1 : nums2[j];
        }
        return res;
    }
}
