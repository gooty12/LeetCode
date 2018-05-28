import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class ValidParenthesis {
    public boolean isValid(String s) {
        HashMap<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
        boolean ans = true;
        Deque<String> stack = new LinkedList<>();
        for (int i = 0 ; ans && i < s.length(); i++) {
            String ch = s.charAt(i) + "";
            if ("([{".indexOf(ch) == -1) {
                ans = !stack.isEmpty() && (stack.removeFirst().equals(map.get(ch)));
            }
            else {
                stack.addFirst(ch);
            }
        }

        if (ans) {
            ans = stack.isEmpty();
        }

        return ans;
    }
}
