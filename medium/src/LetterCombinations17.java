import java.util.ArrayList;
import java.util.List;

public class LetterCombinations17 {
    public static void main(String[] args) {

        LetterCombinations17 obj = new LetterCombinations17();
    }

    char[][] map = new char[][] {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    public List<String> letterCombinations(String digits) {
        return recurse(digits, 0);
    }

    public List<String> recurse(String s, int i) {
        List<String> res = new ArrayList<String>();
        if (i < s.length()) {
            int ind = s.charAt(i)-'2';
            List<String> res2 = recurse(s, i+1);
            if (res2.size() == 0) {
                for (int j = 0; j < map[ind].length; j++) {
                    res.add(map[ind][j]+"");
                }
            }
            else {
                for (int j = 0; j < res2.size(); j++) {
                    String str = res2.get(j);
                    for (int k = 0; k < map[ind].length; k++) {
                        res.add(map[ind][k]+str);
                    }
                }
            }
        }
        return res;
    }
}
