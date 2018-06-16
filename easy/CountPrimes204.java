import java.util.Arrays;

public class CountPrimes204 {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int sqrt = (int)(Math.ceil(Math.sqrt(n)));
        int res = n>2 ? 1 : 0;
        int i;
        for (i = 3; i <= sqrt; i += 2) {
            if (primes[i]) {
                res += 1;
                for (int j = i*i; j < n; j += 2*i) {
                    primes[j] = false;
                }
            }
        }
        for (; i < n; i+=2) {
            res += (primes[i] ? 1 : 0);
        }
        return res;
    }
}
