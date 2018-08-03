public class BitwiseAND201 {
    public static void main(String[] args) {

        BitwiseAND201 obj = new BitwiseAND201();
        obj.rangeBitwiseAnd2(1, 3);
    }

    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        int p = 1;
        int a = m;
        long curr = 0;
        while (a > 0) {
            int b = a % 2;
            curr += b*(int)Math.pow(2, p-1);
            if (b == 1) {
                int diff =  (int)((long)Math.pow(2, p) - curr);
                if (n-m < diff)  {
                    res += (int)Math.pow(2, p-1);
                }
            }
            p += 1;
            a /= 2;
        }
        return res;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        int res = 0;
        String s1 = Integer.toBinaryString(m);
        String s2 = Integer.toBinaryString(n);
        if (s1.length() == s2.length()) {
            int i = 0;
            for (; i < s1.length(); i++) {
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(i);
                if (ch1 == ch2) {
                    res = res*2 + ch1 - '0';
                }
                else {
                    break;
                }
            }
            res <<= (s1.length()-i);
        }
        return res;
    }
}
