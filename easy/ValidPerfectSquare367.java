public class ValidPerfectSquare367 {
    public boolean isPerfectSquare(int num) {
        int start = 1, end = Math.max(start, num/2);
        boolean res = false;
        while (!res && start <= end) {
            long mid = (start + end) / 2;
            long sq = mid * mid;
            if (sq == num) {
                res = true;
            }
            else if (sq > num) {
                end = (int)(mid -1);
            }
            else {
                start = (int)(mid + 1);
            }
        }
        return res;
    }
}
