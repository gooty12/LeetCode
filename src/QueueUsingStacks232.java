import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingStacks232 {
    /** Initialize your data structure here. */
    Deque<Integer> stack;
    public  QueueUsingStacks232() {
        stack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Deque<Integer> temp = new LinkedList<>();
        while(!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        stack.push(x);
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
