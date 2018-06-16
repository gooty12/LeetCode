public class FindTheDifference389 {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[(int)s.charAt(i)-97] -= 1;
            count[(int)t.charAt(i)-97] += 1;
        }
        count[(int)t.charAt(t.length()-1)-97] += 1;
        int indx = 0;
        for (indx = 0; count[indx] == 0; indx++);
        return (char)(97+indx);
    }
}
