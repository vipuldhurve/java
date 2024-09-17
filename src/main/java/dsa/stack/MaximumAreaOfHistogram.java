package dsa.stack;

import java.util.Arrays;
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

    //    TIME COMPLEXITY: O(N)   |   SPACE COMPLEXITY: O(N)
    public static int maximumAreaOfHistogram(int[] heights) {
//        Calculate index of nearest smaller to left
        int[] nsl = nearestSmallerToLeft(heights);
//        Calculate index of nearest smaller to right
        int[] nsr = nearestSmallerToRight(heights);

        int mah = Integer.MIN_VALUE;
//        Max width up to which a bar can be extended
//        width[i] = nsr[i]-nsl[i]-1
        for (int i = 0; i < heights.length; i++) {
            mah = Math.max(mah, (nsr[i] - nsl[i] - 1) * heights[i]);
        }

        if (mah == Integer.MIN_VALUE) return 0;
        return mah;
    }

    public static int[] nearestSmallerToLeft(int[] heights) {
        int[] result = new int[heights.length];

//        Stack will store the val and index of nearest_greater_to_left - A Node object
        Stack<Node> s = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            if (s.isEmpty()) {
                result[i] = -1;
            } else if (!s.isEmpty() && s.peek().val < heights[i]) {
                result[i] = s.peek().index;
            } else if (!s.isEmpty() && s.peek().val >= heights[i]) {
                while (!s.isEmpty() && s.peek().val >= heights[i]) {
                    s.pop();
                }
                if (s.isEmpty()) result[i] = -1;
                else result[i] = s.peek().index;
            }
            s.push(new Node(heights[i], i));
        }
        return result;
    }

    public static int[] nearestSmallerToRight(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];

//        Stack will store the val and index of nearest_greater_to_right - A Node object
        Stack<Node> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                result[i] = n;
            } else if (!s.isEmpty() && s.peek().val < heights[i]) {
                result[i] = s.peek().index;
            } else if (!s.isEmpty() && s.peek().val >= heights[i]) {
                while (!s.isEmpty() && s.peek().val >= heights[i]) {
                    s.pop();
                }
                if (s.isEmpty()) result[i] = n;
                else result[i] = s.peek().index;
            }
            s.push(new Node(heights[i], i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {6, 2, 5, 4, 5, 1, 6},
                {2, 1, 5, 6, 2, 3},
                {2, 4}
        };

        Arrays.stream(input)
                .peek(i -> System.out.println("INPUT: " + Arrays.toString(i)))
                .mapToInt(arr -> maximumAreaOfHistogram(arr))
                .forEach(o -> System.out.println("MAXIMUM AREA OF HISTOGRAM: " + o + "\n"));
    }

}
