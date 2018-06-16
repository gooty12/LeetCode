public class ReverseInteger07 {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        long l = 0;
        while (x > 0) {
            l = l*10 + x%10;
            x /= 10;
        }
        final long MINM = (long)Math.pow(-2, 31);
        final long MAXM = (long)Math.pow(2, 31) - 1;
        int res = 0;
        if (l <= MAXM && l >= MINM) {
            res = (int)l;
        }
        return res*sign;
    }
}
