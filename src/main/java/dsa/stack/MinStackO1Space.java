package dsa.stack;

import java.util.Stack;

public class MinStackO1Space {
    // Design a dsa.stack that supports
    // push,
    // pop,
    // top,
    // and retrieving the minimum element in constant time.

    class MinStack {

        Stack<Integer> s;
        int minEle;

        public MinStack() {
            this.s = new Stack<>();
            this.minEle = -1;
        }

        public void push(int val) {
            if (s.isEmpty()) {
                s.push(val);
                minEle = val;
            } else {
                if (val >= minEle) s.push(val);
                else {
                    s.push(2 * val - minEle);
                    minEle = val;
                }
            }
        }

        public void pop() {
            if (s.isEmpty()) return;
            else {
                if (s.peek() >= minEle) s.pop();
                else {
                    minEle = 2 * minEle - s.peek();
                    s.pop();
                }
            }
        }

        public int top() {
            if (s.isEmpty()) return -1;
            else {
                if (s.peek() >= minEle) return s.peek();
                else return minEle;
            }
        }

        public int getMin() {
            if (s.isEmpty()) return -1;
            return minEle;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello :)");
    }

}
