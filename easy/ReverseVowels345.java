public class ReverseVowels345 {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] str = s.toCharArray();
        for (int i = 0, j = str.length-1; i < j; ) {
            char c1 = str[i];
            char c2 = str[j];
            boolean b1 = vowels.contains(c1 + "");
            boolean b2 = vowels.contains(c2 + "");
            if (b1 && b2) {
                str[i] = c2;
                str[j] = c1;
                i += 1;
                j -= 1;
            }
            else if (b1) {
                j -= 1;
            }
            else if (b2) {
                i += 1;
            }
            else {
                i += 1;
                j -= 1;
            }
        }
        return String.valueOf(str);
    }
}
