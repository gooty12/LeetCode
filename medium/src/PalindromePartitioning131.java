import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning131 {
    public static void main(String[] args) {

        PalindromePartitioning131 obj = new PalindromePartitioning131();
    }

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        recurse(s, 0, new LinkedList<>());
        return res;
    }

    public void recurse(String s, int indx, List<String> l) {
        if (indx >= s.length()) {
            res.add(new LinkedList<>(l));
        }
        else {
            for (int j = indx; j < s.length(); j++) {
                boolean isPalindrome = true;
                for (int st = indx, end = j; isPalindrome && st <= end; st++, end--) {
                    isPalindrome = s.charAt(st) == s.charAt(end);
                }
                if (isPalindrome) {
                    l.add(s.substring(indx, j+1));
                    recurse(s, j+1, l);
                    l.remove(l.size()-1);
                }
            }
        }
    }
}
