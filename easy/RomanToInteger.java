import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int i = 0;
        int ans = 0;
        while (i < s.length()) {
            String str = s.charAt(i) + "";
            Integer v = null;
            if (i+1 < s.length()) {
                v = map.get(str + s.charAt(i+1));
            }
            if (v == null) {
                v = map.get(str);
                i += 1;
            }
            else {
                i += 2;
            }
            ans += v;
        }

        return ans;
    }
}
