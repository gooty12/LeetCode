import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean res = false;
        for (int i = 0; !res && i < nums.length; i++) {
            Integer j = map.put(nums[i], i);
            if (j != null && i-j <= k) {
                res = true;
            }
        }
        return res;
    }

    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        boolean res = false;
        Pair[] elems = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            elems[i] = new Pair(nums[i], i);
        }
        Arrays.sort(elems, (a, b) -> {
            int res2 = a.x-b.x;
            if (res2 == 0) {
                res2 = a.y - b.y;
            }
            return res2;
        });
        //System.out.println(Arrays.toStr)\
        res = false;
        for (int i = 0; !res && i < elems.length-1; i++) {
            Pair p1 = elems[i];
            Pair p2 = elems[i+1];
            if (p1.x==p2.x && Math.abs(p1.y-p2.y)<=k) {
                res = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ContainsDuplicate219 obj = new ContainsDuplicate219();
        boolean res = obj.containsNearbyDuplicate2(new int[]{1,2,3,1}, 3);
    }

}
