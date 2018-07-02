import java.util.*;

public class GroupAnagrams49 {
    public static void main(String[] args) {

        GroupAnagrams49 obj = new GroupAnagrams49();
        obj.groupAnagrams(new String[]{"eat", "tea"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int indx = s.charAt(i) - 'a';
                count[indx] += 1;
            }
            StringBuilder key = new StringBuilder();
            for (int n : count) {
                key.append(n);
            }
            List<String> l = new ArrayList<>();
            l.add(s);
            map.merge(key.toString(), l, (ol, nw) -> { ol.addAll(nw); return ol; });
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
}
