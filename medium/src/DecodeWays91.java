public class DecodeWays91 {
    public static void main(String[] args) {

        DecodeWays91 obj = new DecodeWays91();
    }

    public int numDecodings(String s) {
        return recurse(s, 0);
    }

    public int recurse(String s, int ind) {
        int ways = 0;
        if (ind >= s.length()) {
            ways = 1;
        }
        else {
            int d1 = s.charAt(ind) - '0';
            if (d1 > 0) {
                ways += recurse(s, ind+1);
                if (ind+1 < s.length()) {
                    int d2 = s.charAt(ind+1) - '0';
                    int val = d1*10 + d2;
                    if (val <= 26) {
                        ways += recurse(s, ind+2);
                    }
                }
            }
        }
        return ways;
    }
}
