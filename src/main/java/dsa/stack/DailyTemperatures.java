package dsa.stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DailyTemperatures {
//    You are given an array of integers temperatures
//    where temperatures[i] represents the daily temperatures on the ith day.

//    Return an array result
//    where result[i] is the number of days after the ith day
//    before a warmer temperature appears on a future day.
//    If there is no day in the future where a warmer temperature will appear
//    for the ith day, set result[i] to 0 instead.

//    Input: temperatures = [30,38,30,36,35,40,28]
//    Output: [1,4,1,2,1,0,0]

//    Input: temperatures = [22,21,20]
//    Output: [0,0,0]


    //    Helper class to store temperature value and its index in array
    private static class Pair {
        int temp, index;

        public Pair(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }
    }

    private static int[] dailyTemperatures(int[] temperatures) {
//        A stack to get the next greater to right
        Stack<Pair> stack = new Stack<>();
//        Create array to store greater temperature if found
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            Pair p = new Pair(temperatures[i], i);
//            If stack is empty that means no greater temp to right
            if (stack.isEmpty()) result[i] = 0;
            else {
//                Remove temp values smaller than current temp from stack
                while (stack.size() > 0 && temperatures[i] >= stack.peek().temp) stack.pop();
//                Check if greater temp val found in stack i.e. right of array
                if (stack.isEmpty()) result[i] = 0;
                else result[i] = stack.peek().index - i;
            }
//            Add current temp in stack
            stack.push(p);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] temperatures = new int[][]{
                {30, 38, 30, 36, 35, 40, 28},
                {22, 21, 20}
        };

        Map<int[], int[]> resultMap = Arrays.stream(temperatures)
                .collect(Collectors.toMap(
                        x -> x,
                        DailyTemperatures::dailyTemperatures
                ));


        resultMap.forEach((key, val) ->
                System.out.println("Input: " + Arrays.toString(key) + "\nOuput: " + Arrays.toString(val) + "\n")
        );
    }
}
