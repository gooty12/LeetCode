import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        boolean res = true;
        for (int i = 0; res && i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);
            Character cc1 = map1.get(c1);
            Character cc2 = map2.get(c2);
            if (cc1 == null && cc2 == null) {
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
            else if (cc1 == null || cc2 == null) {
                res = false; //c1.equals(cc2);
            }
            else {
                res = cc1.equals(c2) && cc2.equals(c1);
            }
        }
        return res;
    }
}
