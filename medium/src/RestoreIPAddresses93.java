import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
    public static void main(String[] args) {

        RestoreIPAddresses93 obj = new RestoreIPAddresses93();
    }

    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        recurse(s, 0, 1, new StringBuilder());
        return res;
    }

    public void recurse(String s, int indx, int count, StringBuilder sb) {
        if (indx < s.length()) {
            int sz = sb.length();
            if (count == 4) {
                if (s.charAt(indx) != '0' || (s.charAt(indx) =='0' && indx == s.length()-1)) {
                    long val = 0;
                    for (int i = indx; i < s.length(); i++) {
                        val = val * 10 + s.charAt(i)-'0';
                    }
                    if (val <= 255) {
                        sb.append(s.substring(indx, s.length()));
                        res.add(sb.toString());
                    }
                }
            }
            else {
                int val = 0;
                if (s.charAt(indx)=='0') {
                    recurse(s, indx+1, count+1, sb.append("0."));
                }
                else {
                    for (int i = indx; i < indx+3 && i < s.length(); i++) {
                        val = val * 10 + s.charAt(i)-'0';
                        if (val <= 255) {
                            recurse(s, i+1, count+1, sb.append(s.charAt(i)+"."));
                            sb.deleteCharAt(sb.length()-1);
                        }
                    }
                }
            }
            sb.delete(sz, sb.length());
        }
    }
}
