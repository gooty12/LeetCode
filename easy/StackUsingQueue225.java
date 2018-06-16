import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue225 {
    /** Initialize your data structure here. */
    Queue<Integer> q;
    public StackUsingQueue225() {
        q = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int prev = -1;
        Queue<Integer> temp = new LinkedList<>();
        while (!q.isEmpty()) {
            prev = q.remove();
            if (!q.isEmpty()) {
                temp.offer(prev);
            }
        }
        q = temp;
        return prev;
    }

    /** Get the top element. */
    public int top() {
        int prev = -1;
        Queue<Integer> temp = new LinkedList<>();
        while (!q.isEmpty()) {
            prev = q.remove();
            temp.offer(prev);
        }
        q = temp;
        return prev;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
