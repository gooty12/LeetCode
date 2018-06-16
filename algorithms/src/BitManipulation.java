public class BitManipulation {
    public static void main(String[] args) {
        int n = -12;
        while (n != 0) {
            // n >>= 1; ### signed shift infinite loop
            n >>>= 1; // unsigned shift, ends with 0. Beware of BIG positive numbers
            System.out.println(n);
        }
        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toBinaryString(n));
    }
}
