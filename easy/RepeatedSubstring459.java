public class RepeatedSubstring459 {
    public boolean repeatedSubstringPattern(String s) {
        boolean res = false;
        int len = s.length();
        for (int l= 1; !res && l <= len/2; l++) {
            if (len % l == 0) {
                res = true;
                String s1 = s.substring(0,l);
                for (int j = l; res && j+l <= len; j += l) {
                    res = s1.equals(s.substring(j, j+l));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RepeatedSubstring459 obj = new RepeatedSubstring459();
        obj.repeatedSubstringPattern("abab");
    }
}
