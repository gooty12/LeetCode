import java.util.Deque;
import java.util.LinkedList;

public class PalindromeNumber09 {

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

    public boolean isPalindrome2(int x) {
        boolean ans;
        if (x < 0) {
            ans = false;
        }
        else if (x < 10) {
            ans = true;
        }
        else if (x % 10 == 0) {
            ans = false;
        }
        else {
            int num1 = x;
            int num2 = 0;
            while (num2 < num1) {
                num2 = num2*10 + num1%10;
                num1 /= 10;
            }
            ans = ((num1 == num2) || (num1 == num2/10));
        }

        return ans;
    }
}
