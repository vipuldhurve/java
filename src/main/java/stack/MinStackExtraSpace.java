package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinStackExtraSpace {
    // Design a stack that supports
    // push,
    // pop,
    // top,
    // and retrieving the minimum element in constant time.

    class MinStack {

        Stack<Integer> s;
        Stack<Integer> minStack;

        public MinStack() {
            this.s = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            s.push(val);
            if (s.isEmpty() || val <= minStack.peek()) minStack.push(val);
        }

        public void pop() {
            int popped = s.pop();
            if(!s.isEmpty() && popped == minStack.peek()) minStack.pop();
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello :)");
    }

}
