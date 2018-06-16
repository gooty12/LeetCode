public class ArrangingCoins441 {
    public int arrangeCoins(int n) {
        int sqrt = (int)Math.sqrt(2*(long)n);
        long res = 0;
        if (n > 0) {
            for (res = sqrt; res*(res+1) > 2L*n; res--);
        }
        return (int)res;
    }
}
