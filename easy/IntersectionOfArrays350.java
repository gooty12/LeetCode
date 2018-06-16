import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArrays350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.merge(n, 1, (ol, nw) -> ol + 1);
        }
        List<Integer> l = new ArrayList<>();
        for (int n2 :  nums2) {
            Integer count = map.get(n2);
            if (count == null) {
                continue;
            }
            else if (count==1){
                map.remove(n2);
                l.add(n2);
            }
            else {
                map.put(n2, count-1);
                l.add(n2);
            }
        }
        return l.stream().mapToInt(n -> n).toArray();
    }
}
