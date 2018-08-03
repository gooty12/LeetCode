public class PrimePalindrome866 {
    public static void main(String[] args) {

        PrimePalindrome866 obj = new PrimePalindrome866();
    }

    public int primePalindrome(int N) {
        int res = 0;
        res = N>=8 && N<=11 ? 11 : 0;
        for (int j = 10; res == 0 && j <= 100000; j *= 10) {
            for (int i = j/10; i<j; i++) {
                StringBuilder sb = new StringBuilder(i + "");
                for (int k = sb.length()-2; k >= 0; k--) {
                    sb.append(sb.charAt(k));
                }
                int n1 = Integer.valueOf(sb.toString());
                if (n1 >= N && isPrime(n1)) {
                    res = n1;
                    break;
                }
            }
        }
        return res;
    }

    public boolean isPrime(int n) {
        boolean prime = false;
        if (n > 1) {
            int sq = (int)Math.sqrt(n);
            prime = true;
            for (int i = 2; prime && i <= sq; i++) {
                prime = n%i != 0;
            }
        }
        return prime;
    }
}
