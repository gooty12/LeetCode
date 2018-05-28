import java.util.Deque;
import java.util.LinkedList;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        boolean ans;
        if (x < 0) {
            ans = false;
        }
        else if (x < 10) {
            ans = true;
        }
        else {
            Deque<Integer> digits = new LinkedList<>();
            while (x > 0) {
                digits.add(x%10 );
                x /= 10;
            }
            ans = true;
            while (!digits.isEmpty()) {
                int first = digits.removeFirst();
                if (!digits.isEmpty()) {
                    int last = digits.removeLast();
                    if (first != last) {
                        ans = false;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
