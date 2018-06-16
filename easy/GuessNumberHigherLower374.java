public class GuessNumberHigherLower374 {
    public int guessNumber(int n) {
        int start = 1, end = n;
        int res = -1;
        while (start <= end) {
            int  mid = start + (end-start)/2;
            int g = guess(mid);
            if (g  == 0) {
                res = mid;
                break;
            }
            else if (g == -1) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return res;
    }

    public int guess(int n) {
        return -1;
    }
}
