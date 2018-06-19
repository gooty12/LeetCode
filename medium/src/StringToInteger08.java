public class StringToInteger08 {
    public static void main(String[] args) {

        StringToInteger08 obj = new StringToInteger08();
    }

    public int myAtoi(String s) {
        double res = 0;
        if (s != null && !s.isEmpty()) {
            int i = 0;
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-' || Character.isDigit(s.charAt(i)))) {
                int sign = 1;
                if (!Character.isDigit(s.charAt(i))) {
                    sign = s.charAt(i)=='-' ? -1 : 1;
                    i += 1;
                }
                for (; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
                    res = res * 10 + s.charAt(i)-'0';
                }
                res = res * sign;
                if (res > Integer.MAX_VALUE) {
                    res = Integer.MAX_VALUE;
                }
                else if (res < Integer.MIN_VALUE) {
                    res = Integer.MIN_VALUE;
                }
            }
        }
        return (int)res;
    }
}
