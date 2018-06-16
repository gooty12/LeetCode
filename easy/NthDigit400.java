public class NthDigit400 {
    public int findNthDigit(int n) {
        int digits = 1;
        for (; digits > 0; digits++) {
            int count = (int)(9 * Math.pow(10, digits-1)) * digits;
            if (n <= count) {
                break;
            }
            n -= count;
        }
        int offset = n / digits;
        int num = (int)Math.pow(10, digits-1) + offset - 1;
        int mod = n % digits;
        num = mod == 0 ? num : num + 1;
        mod = mod == 0 ? digits : mod;
        num = num / (int)(Math.pow(10, digits-mod));
        return num % 10;
    }

    public static void main(String[] args) {
        NthDigit400 obj = new NthDigit400();
        System.out.println(obj.findNthDigit(1000));
    }
}
