import java.util.HashMap;
import java.util.Map;

public class LongestSubstring03 {
    public static void main(String[] args) {

        LongestSubstring03 obj = new LongestSubstring03();
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s != null && !s.isEmpty()) {
            int start = 0;
            int j = 1;
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(0), 0);
            for (j = 1; j < s.length(); j++) {
                char ch = s.charAt(j);
                Integer ind = map.put(ch, j);
                if (ind != null && ind >= start) {
                    res = Math.max(res, j-start);
                    start = ind + 1;
                }
            }
            res = Math.max(res, j-start);
        }
        return res;
    }
}
