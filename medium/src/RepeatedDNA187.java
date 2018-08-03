import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNA187 {
    public static void main(String[] args) {

        RepeatedDNA187 obj = new RepeatedDNA187();
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> l = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            map.merge(s.substring(i, i+10), 1, (ol, nw) -> ol + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                l.add(entry.getKey());
            }
        }
        return l;
    }
}
