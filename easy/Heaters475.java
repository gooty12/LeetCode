import java.util.NavigableSet;
import java.util.TreeSet;

public class Heaters475 {
    public int findRadius(int[] houses, int[] heaters) {
        NavigableSet<Integer> set = new TreeSet<>();
        for (int h : heaters) {
            set.add(h);
        }
        int res = -1;
        for (int hs : houses) {
            Integer h = set.ceiling(hs);
            Integer l = set.floor(hs);
            int close = (int)(Math.pow(10,9)+1);
            if (l != null) {
                close = Math.min(close, hs-l);
            }
            if (h != null) {
                close = Math.min(close, h-hs);
            }
            res = Math.max(res, close);
        }
        return res;
    }
}
