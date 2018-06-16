import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        boolean res = pattern.length()==words.length;
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; res && i < words.length; i++) {
            String s1 = map1.get(pattern.charAt(i));
            Character ch = map2.get(words[i]);
            if (s1==null && ch == null) {
                map1.put(pattern.charAt(i), words[i]);
                map2.put(words[i], pattern.charAt(i));
            }
            else if (s1==null || ch == null) {
                res = false;
            }
            else {
                res = s1.equals(words[i]);
            }
        }
        return res;
    }
}
