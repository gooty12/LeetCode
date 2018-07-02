public class Pow50 {
    public static void main(String[] args) {

        Pow50 obj = new Pow50();
    }

    public double myPow(double x, int n) {
        double res = 1;
        long n2 = Math.abs(n*1l);
        while (n2 > 0) {
            double p = n > 0 ? x : 1d/x;
            long n1 = 1;
            while (n1*2 <= n2) {
                p *= p;
                n1 *= 2;
            }
            res *= p;
            n2 -= n1;
        }
        return res;
    }
}
