import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class MinStack155 {
    /** initialize your data structure here. */
    int minm;
    Deque<Integer> stack;
    public MinStack155() {
        stack = new LinkedList<>();
        minm = Integer.MAX_VALUE;
    }

    public void push(int x) {
        minm = Math.min(minm, x);
        stack.push(x);
    }

    public void pop() {
        int val = stack.pop();
        if (val <= minm) {
            if (!stack.isEmpty()) {
                minm = Collections.min(stack);
            }
            else {
                minm = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minm;
    }
}
