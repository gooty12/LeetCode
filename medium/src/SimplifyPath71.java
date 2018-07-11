import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath71 {
    public static void main(String[] args) {

        SimplifyPath71 obj = new SimplifyPath71();
    }

    public String simplifyPath(String path) {
        String res = "";
        if (path != null) {
            String[] names = path.split("/+");
            Deque<String> stack = new LinkedList();
            for (String s : names) {
                if (!s.isEmpty()) {
                    if (!s.equals(".")) {
                        if (s.equals("..")) {
                            if (!stack.isEmpty()) {
                                stack.pop();
                            }
                        }
                        else {
                            stack.push(s);
                        }
                    }
                }
            }
            res = "/";
            if (!stack.isEmpty()) {
                res = "";
                while (!stack.isEmpty()) {
                    res += "/" + stack.removeLast();
                }
            }
        }
        return res;
    }
}
