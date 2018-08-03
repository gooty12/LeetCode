import java.util.Deque;
import java.util.LinkedList;

public class ReversePolishNotation150 {
    public static void main(String[] args) {

        ReversePolishNotation150 obj = new ReversePolishNotation150();
    }

    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        stack.push("0");
        for (String s : tokens) {
            if (s.length() == 1 && !Character.isDigit(s.charAt(0))) {
                int op1 = Integer.valueOf(stack.pop());
                int op2 = Integer.valueOf(stack.pop());
                stack.push("" + cal(s, op1, op2));
            }
            else {
                stack.push(s);
            }
        }

        return Integer.valueOf(stack.pop());
    }

    public int cal(String s, int op1, int op2) {
        char ch = s.charAt(0);
        int res = 0;
        if (ch == '+') {
            res = op1 + op2;
        }
        else if (ch == '-') {
            res = op2 - op1;
        }
        else if (ch == '*') {
            res = op1 * op2;
        }
        else {
            res = op2 / op1;
        }
        return res;
    }
}
