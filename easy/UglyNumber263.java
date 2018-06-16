public class UglyNumber263 {
    public boolean isUgly(int num) {
        int n = num;
        boolean res = true;
        if (n <= 0) {
            res = false;
        }
        while (res && n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            }
            else if (n % 5 == 0) {
                n /= 5;
            }
            else if (n % 3 == 0) {
                n /= 3;
            }
            else {
                res = false;
            }
        }
        return res;
    }
}
