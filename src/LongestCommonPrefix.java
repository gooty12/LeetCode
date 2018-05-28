public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        boolean b = true;
        if (strs.length == 0) {
            ans = "";
        }
        else if (strs.length == 1) {
            ans = strs[0];
        }
        else {
            int i = 0;
            while (b) {
                String s = strs[0];
                char ch = 'b';
                if (i < s.length()) {
                    ch = s.charAt(i);
                }
                else {
                    b = false;
                }
                for (int j = 0; b && j < strs.length; j++) {
                    s = strs[j];
                    if (i < s.length()) {
                        b = (ch == s.charAt(i));
                    }
                    else {
                        b = false;
                    }
                }
                if (b) {
                    ans += ch;
                }
                i++;
            }
        }

        return ans;
    }
}
