public class PowerOfTwo231 {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while (n > 0 && count <= 1) {
            count += n%2;
            n /= 2;
        }
        return count==1;
    }
}
