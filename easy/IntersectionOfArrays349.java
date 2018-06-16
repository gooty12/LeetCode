import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> l = new ArrayList<>();
        for (int index1 = 0, index2 = 0; index1 < nums1.length && index2 < nums2.length;) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1 == num2) {
                if (l.size()==0 || num1 != l.get(l.size()-1)) {
                    l.add(num1);
                }
                index1 += 1;
                index2 += 1;
            }
            else if (num1 < num2){
                index1 += 1;
            }
            else {
                index2 += 1;
            }
        }

        return l.stream().mapToInt(n -> n).toArray();
    }
}
