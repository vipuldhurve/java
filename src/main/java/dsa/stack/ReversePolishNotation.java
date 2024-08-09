package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class ReversePolishNotation {
//    You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.

//    Return the integer that represents the evaluation of the expression.

//    The operands may be integers or the results of other operations.
//    The operators include '+', '-', '*', and '/'.
//    Assume that division between integers always truncates toward zero.

//    Input: tokens = ["1","2","+","3","*","4","-"]
//    Output: 5
//    Explanation: ((1 + 2) * 3) - 4 = 5

    private static int reversePolishNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) stack.push(stack.pop() + stack.pop());
            else if (tokens[i].equals("-")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y - x);
            } else if (tokens[i].equals("*")) stack.push(stack.pop() * stack.pop());
            else if (tokens[i].equals("/")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y / x);
            } else stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] inputArray = new String[]{"1", "2", "+", "3", "*", "4", "-"};
        System.out.println("Input: " + Arrays.toString(inputArray) + "\nOutput: " + reversePolishNotation(inputArray));
    }

}
