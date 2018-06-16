public class NumberComplement476 {
    public int findComplement(int num) {
        int p = 1;
        int res = 0;
        while (num > 0) {
            res += p * (1 - num%2);
            p *= 2;
            num /= 2;
        }
        return res;
    }
}
