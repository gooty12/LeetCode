import java.util.HashMap;
import java.util.Map;

public class HappyNumber202 {
    public boolean isHappy(int n) {
        boolean res = false;
        if (n != 0) {
            Map<Integer, Integer> map;
            map = new HashMap<>();
            map.put(n, 1);
            while (!res) {
                int temp = n;
                int next = 0;
                while (temp > 0) {
                    next += (int)Math.pow(temp%10, 2);
                    temp /= 10;
                }
                if (next == 1) {
                    res = true;
                }
                else if (map.containsKey(next) ) {
                    res = false;
                    break;
                }
                else {
                    map.put(next, 1);
                }
                n = next;
            }
        }
        return res;
    }
}
