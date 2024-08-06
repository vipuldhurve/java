package dsa.stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ValidParentheses {
//    You are given a string s consisting of the following characters:
//    '(', ')', '{', '}', '[' and ']'.

    //    An input string is valid if:
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//    Every close bracket has a corresponding open bracket of the same type.
    private static boolean validParentheses(String s) {
        if (s.length() == 0 || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') stack.push(c);
            else if (!stack.isEmpty() && ((c == ')' && stack.peek() == '(')
                    || (c == '}' && stack.peek() == '{')
                    || (c == ']' && stack.peek() == '['))) stack.pop();
            else return false;
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String[] inputArray = new String[]{
                "()",
                "(){}[]",
                "(]",
                "[",
                "(()}",
                ""
        };
        Map<String, Boolean> resultMap = Arrays.stream(inputArray)
                .collect(Collectors.toMap(
                        x -> x,
                        ValidParentheses::validParentheses
                ));

        resultMap.forEach((key, val) -> System.out.println(
                "Input: \"" + key + "\"\nisValid: " + val + "\n"
        ));
    }
}
