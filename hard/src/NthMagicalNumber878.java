public class NthMagicalNumber878 {
    public static void main(String[] args) {

        NthMagicalNumber878 obj = new NthMagicalNumber878();
    }

    public int nthMagicalNumber(int N, int A, int B) {

        long a = Math.max(A, B);
        long b = Math.min(A, B);

        long lcm = a * b;
        lcm = lcm / gcd(a, b);
        long st = 1, end = N * a;
        long MOD = (long)(Math.pow(10, 9)) + 7;
        int res = 1;
        while (st <= end) {
            long mid = st + (end - st)/2;
            long n = mid/A + mid/B - mid/lcm;
            if (n == N && (mid%A == 0 || mid%B == 0)) {
                res = (int)(mid % MOD);
                break;
            }
            else if (n >= N) {
                end = mid - 1;
            }
            else {
                st = mid + 1;
            }
        }

        return res;
    }

    public long gcd(long a, long b) {
        long res = 1;
        if (b == 0) {
            res = a;
        }
        else {
            res = gcd(b, a%b);
        }
        return res;
    }
}
