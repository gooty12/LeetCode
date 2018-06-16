public class TrailingZeroes172 {
    public int trailingZeroes(int n) {
        int res = 0;
        for (long p = 5; p <= n; p *= 5){
            res += n/p ;
        }
        return res;

    }
}
