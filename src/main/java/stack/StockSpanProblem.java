package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    //The stock span problem is a financial problem where we have
    // a series of N daily price quotes for a stock and
    // we need to calculate the span of the stock’s price for all N days.
    // The span Si of the stock’s price on a given day i is defined as
    // the maximum number of consecutive days just before the given day,
    // for which the price of the stock on the current day is less than
    // or equal to its price on the given day.

    //Example 1
    //Input: 100, 80, 60, 70, 60, 75, 85
    //Ouput: 1, 1, 1, 2, 1, 4, 6

    //Example 2
    //Input: 10 4 5 90 120 80
    //Output: 1 1 2 4 5 1

    static class Node {
        int val;
        int index;

        Node(int val, int index) {
            this.index = index;
            this.val = val;
        }
    }

    public static int[] stockSpan(int[] arr) {
        int[] result = new int[arr.length];

        //Stack will store the val and index of nearest greater to left
        Stack<Node> s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (s.isEmpty()) {
                result[i] = -1;
            } else if (!s.isEmpty() && s.peek().val > arr[i]) {
                result[i] = s.peek().index;
            } else if (!s.isEmpty() && s.peek().val <= arr[i]) {
                while (!s.isEmpty() && s.peek().val <= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) result[i] = -1;
                else result[i] = s.peek().index;
            }
            s.push(new Node(arr[i], i));
        }

        //Subtracting index of nearest_greater_to_left from index in arr
        for (int i = 0; i < arr.length; i++) {
            result[i] = i - result[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] input = new int[][]{
                {100, 80, 60, 70, 60, 75, 85},
                {10, 4, 5, 90, 120, 80}
        };

        int[][] output = Arrays.stream(input)
                .map(arr -> stockSpan(arr))
                .toArray(int[][]::new);

        for (int i = 0; i < input.length; i++) {
            System.out.print("Input: ");
            printArray(input[i]);
            System.out.print("Output: ");
            printArray(output[i]);
            System.out.println();
        }
    }

    public static void printArray(int[] A) {
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

}
