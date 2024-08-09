package dsa.stack;

import java.util.Stack;

public class MinStackExtraSpace {
    // Design a dsa.stack that supports
    // push,
    // pop,
    // top,
    // and retrieving the minimum element in constant time.

    private static class MinStack {

        Stack<Integer> s;
        Stack<Integer> minStack;

        public MinStack() {
            this.s = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            s.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) minStack.push(val);
        }

        public void pop() {
            if (s.isEmpty()) return;
            int popped = s.pop();
            if (!minStack.isEmpty() && popped == minStack.peek()) minStack.pop();
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.pop();
        minStack.push(1);
        minStack.pop();
        minStack.push(4);
        System.out.println(minStack.getMin());
    }

}
