package stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxAreaRectangleInBinaryMatrix {

    //Given a rows x cols binary matrix filled with 0's and 1's,
    // find the largest rectangle containing only 1's and return its area.

    //Example 1
//    Input: matrix = [
//            ["1","0","1","0","0"],
//            ["1","0","1","1","1"],
//            ["1","1","1","1","1"],
//            ["1","0","0","1","0"]
//            ]
    //Ouput: 6

    //Example 2
    //Input: matrix = [["0"]]
    //Output: 0

    //Example 3
    //Input: matrix = [["1"]]
    //Output: 1

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

    public static int maxAreaRectangleInBinaryMatrix(char[][] matrix) {
        if (matrix.length == 0) return 0;

        //Create histogram array for 0 index -> 1st array in matrix
        int[][] numMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') numMatrix[0][i] = 1;
            else numMatrix[0][i] = 0;
        }
        //Calculate max area of 1st array in matrix
        int maxArea = maximumAreaOfHistogram(numMatrix[0]);

        //Create histogram for rest of the matrix arrays by adding previous array values
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') numMatrix[i][j] = numMatrix[i - 1][j] + 1;
                else numMatrix[i][j] = 0;
            }
            maxArea = Math.max(maxArea, maximumAreaOfHistogram(numMatrix[i]));
        }

        return maxArea;
    }


    public static void main(String[] args) {
        char[][][] input = new char[][][]{
                {
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '1', '1', '0'}
                },
                {
                    {'0'}
                },
                {
                    {'1'}
                }
        };

        int[] result = Arrays.stream(input)
                .mapToInt(arr -> maxAreaRectangleInBinaryMatrix(arr))
                .toArray();

        for (int i = 0; i < input.length; i++) {
            System.out.println("Input :");
            for (int j = 0; j < input[i].length; j++) {
                for (int k = 0; k < input[i][j].length; k++) {
                    System.out.print(input[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println("Output: "+result[i]);
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
