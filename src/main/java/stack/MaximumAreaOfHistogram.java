package stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class MaximumAreaOfHistogram {

    //Given an array of integers heights representing the histogram's bar height
    // where the width of each bar is 1,
    // return the area of the largest rectangle in the histogram.

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

    public static int[] nearestSmallerToLeft(int[] arr) {
        int[] result = new int[arr.length];

        //Stack will store the val and index of nearest_greater_to_left - A Node object
        Stack<Node> s = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (s.isEmpty()) {
                result[i] = -1;
            } else if (!s.isEmpty() && s.peek().val < arr[i]) {
                result[i] = s.peek().index;
            } else if (!s.isEmpty() && s.peek().val >= arr[i]) {
                while (!s.isEmpty() && s.peek().val >= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) result[i] = -1;
                else result[i] = s.peek().index;
            }
            s.push(new Node(arr[i], i));
        }
        return result;
    }

    public static int[] nearestSmallerToRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        //Stack will store the val and index of nearest_greater_to_right - A Node object
        Stack<Node> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                result[i] = n;
            } else if (!s.isEmpty() && s.peek().val < arr[i]) {
                result[i] = s.peek().index;
            } else if (!s.isEmpty() && s.peek().val >= arr[i]) {
                while (!s.isEmpty() && s.peek().val >= arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) result[i] = n;
                else result[i] = s.peek().index;
            }
            s.push(new Node(arr[i], i));
        }
        return result;
    }

    public static int maximumAreaOfHistogram(int[] arr) {
        //Calculate index of nearest smaller to left
        int[] nsl = nearestSmallerToLeft(arr);
        //Calculate index of nearest smaller to right
        int[] nsr = nearestSmallerToRight(arr);

        int mah = Integer.MIN_VALUE;
        //Max width up to which a bar can be extended
        //width[i] = nsr[i]-nsl[i]-1
        for (int i = 0; i < arr.length; i++) {
            mah = Math.max(mah, (nsr[i] - nsl[i] - 1) * arr[i]);
        }

        if (mah == Integer.MIN_VALUE) return 0;
        return mah;
    }


    public static void main(String[] args) {
        int[][] input = new int[][]{
                {6, 2, 5, 4, 5, 1, 6},
                {2, 1, 5, 6, 2, 3},
                {2, 4}
        };

        int[] result = Arrays.stream(input)
                .mapToInt(arr -> maximumAreaOfHistogram(arr))
                .toArray();

        for (int i = 0; i < input.length; i++) {
            System.out.print("Input: ");
            printArray(input[i]);
            System.out.print("Maximum Area of Histogram: ");
            System.out.println(result[i]);
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
