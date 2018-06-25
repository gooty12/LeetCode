import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman12 {
    public static void main(String[] args) {

        IntegerToRoman12 obj = new IntegerToRoman12();
    }

    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        String res = "";
        int p = 1;
        while (num > 0) {
            int dig = num % 10;
            int m = dig * p;
            String s = map.get(m);
            if (s == null) {
                if (dig < 5) {
                    s = repeat(dig, map.get(p));
                }
                else {
                    s = map.get(5*p);
                    s += repeat(dig-5, map.get(p));
                }
            }
            p *= 10;
            res = s + res;
            num /= 10;
        }
        return res;
    }

    public String repeat(int n, String s) {
        String res = "";
        while (n > 0) {
            res += s;
            n -= 1;
        }
        return res;
    }
}
