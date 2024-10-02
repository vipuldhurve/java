package dsa.dynamicProgramming;

import java.util.*;

public class DifferentWaysToAddParentheses {
//    Given a string expression of numbers and operators,
//    return all possible results from computing
//    all the different possible ways to group numbers and operators.
//    You may return the answer in any order.

//    The test cases are generated such that the output values fit in a 32-bit integer
//    and the number of different results does not exceed 104.

//    Example 1:
//    Input: expression = "2-1-1"
//    Output: [0,2]
//    Explanation:
//            ((2-1)-1) = 0
//            (2-(1-1)) = 2

//    Example 2:
//    Input: expression = "2*3-4*5"
//    Output: [-34,-14,-10,-10,10]
//    Explanation:
//            (2*(3-(4*5))) = -34
//            ((2*3)-(4*5)) = -14
//            ((2*(3-4))*5) = -10
//            (2*((3-4)*5)) = -10
//            (((2*3)-4)*5) = 10

    private static Map<String, List<Integer>> dp;

    private static List<Integer> diffWaysToCompute(String expression) {
        // if solution already computed, return from dp map
        if (dp.containsKey(expression)) return dp.get(expression);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // if operator found split the expression into left and right
            if (c == '+' || c == '-' || c == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftAns = diffWaysToCompute(left);
                List<Integer> rightAns = diffWaysToCompute(right);

                // Calculate ans from sub-problems
                for (int x : leftAns) {
                    for (int y : rightAns) {
                        if (c == '-') ans.add(x - y);
                        else if (c == '+') ans.add(x + y);
                        else if (c == '*') ans.add(x * y);
                    }
                }
            }
        }

        if (ans.isEmpty()) ans.add(Integer.parseInt(expression));
        // save in dp map
        dp.put(expression, ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] input = new String[]{
                "2-1-1",
                "2*3-4*5"
        };

        Arrays.stream(input)
                .peek(i -> {
                    System.out.println("INPUT: " + i);
                    dp = new HashMap<>();
                })
                .map(DifferentWaysToAddParentheses::diffWaysToCompute)
                .forEach(o -> System.out.println("OUTPUT: " + o + "\n"));
    }
}
