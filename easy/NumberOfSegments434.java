public class NumberOfSegments434 {
    public int countSegments(String s) {
        int res = 0;
        s = s.trim();
        for (int i = 0; i < s.length();) {
            boolean b = Character.isWhitespace(s.charAt(i));
            if (b) {
                for (; i < s.length() && Character.isWhitespace(s.charAt(i)); i++);
                res += 1;
            }
            else {
                i++;
            }
        }
        if (!s.isEmpty()) {
            res += 1;
        }
        return res;
    }

    public int countSegments2(String s) {
        int res = 0;
        for (int i = 0; i < s.length();) {
            boolean b = Character.isWhitespace(s.charAt(i));
            if (!b) {
                for (; i < s.length() && !Character.isWhitespace(s.charAt(i)); i++);
                res += 1;
            }
            else {
                i++;
            }
        }

        return res;
    }
}
