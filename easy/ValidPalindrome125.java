public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("\\W+", "");
        s = s.toLowerCase();
        boolean res = true;
        for (int i = 0, j = s.length()-1; res && i <= j; i++, j--) {
            res = s.charAt(i) == s.charAt(j);
        }
        return res;
    }
}
