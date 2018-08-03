import java.util.*;

public class FreedomTrqil514 {
    public static void main(String[] args) {

        FreedomTrqil514 obj = new FreedomTrqil514();
    }

    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            char ch = ring.charAt(i);
            List<Integer> l = new ArrayList<>();
            l.add(i);
            map.merge(ch, l, (ol, nw) -> {ol.addAll(nw); return ol;});
        }

        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        int[] cdist = new int[]{0};
        for (int i = 0; i < key.length(); i++) {
            List<Integer> next = map.get(key.charAt(i));
            int[] ndist = new int[next.size()];
            Arrays.fill(ndist, Integer.MAX_VALUE);
            for (int j = 0; j < curr.size(); j++) {
                int p1 = curr.get(j);
                int d1 = cdist[j];
                for(int k = 0; k < next.size(); k++) {
                    int p2 = next.get(k);
                    int d = Math.abs(p1-p2);
                    d = Math.min(d, ring.length()-d);
                    ndist[k] = Math.min(ndist[k], d+d1+1);
                }
            }
            curr = next;
            cdist = ndist;
        }
        int res = Integer.MAX_VALUE;
        for (int d : cdist) {
            res = Math.min(res, d);
        }
        return res;
    }
}
