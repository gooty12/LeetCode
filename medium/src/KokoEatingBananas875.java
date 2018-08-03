public class KokoEatingBananas875 {
    public static void main(String[] args) {

        KokoEatingBananas875 obj = new KokoEatingBananas875();
    }

    public int minEatingSpeed(int[] piles, int H) {
        int len = piles.length;
        int st = 1, end  = 1000000000;
        int res = 1;
        while (st <= end) {
            double k = st + (end-st)/2;
            int h = 0;
            for (int i = 0; i < len; i++) {
                h += (int)Math.ceil(piles[i]/k);
            }
            if (h > H) {
                st = (int)k + 1;
            }
            else {
                res = (int)k;
                end = (int)k - 1;
            }
        }
        return res;
    }
}
