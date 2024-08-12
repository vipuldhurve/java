package dsa.mathAndGeometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
//    Given an m x n matrix of integers matrix,
//    return a list of all elements within the matrix in spiral order.

//    Input:
//    [1,2]
//    [3,4]
//    Output: [1,2,4,3]

//    Input:
//    [1,2,3]
//    [4,5,6]
//    [7,8,9]
//    Output: [1,2,3,6,9,8,7,4,5]

//    Input:
//    [1, 2, 3, 4]
//    [5, 6, 7, 8]
//    [9, 10, 11, 12]
//    Output: [1,2,3,4,8,12,11,10,9,5,6,7]

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix.length == 0) return spiral;
//        directions
//        0 -> left to right
//        1 -> top to bottom
//        2 -> right to left
//        3 -> bottom to top
        int direction = 0;
//        Mark borders of matrix
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {
            if (direction == 0) {
//                move left to right
                for (int i = left; i <= right; i++) {
                    spiral.add(matrix[top][i]);
                }
                top++;
            } else if (direction == 1) {
//                move top to bottom
                for (int i = top; i <= bottom; i++) {
                    spiral.add(matrix[i][right]);
                }
                right--;
            } else if (direction == 2) {
//                move right to left
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            } else {
//                move bottom to top
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }

        return spiral;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2},
                {3, 4}
        };
        solveAndPrint(input);

        input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solveAndPrint(input);

        input = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        solveAndPrint(input);

        input = new int[][]{};
        solveAndPrint(input);
    }

    private static void solveAndPrint(int[][] input) {
        System.out.println("Input: ");
        printMatrix(input);
        System.out.println("Spiral Order: " + spiralOrder(input) + "\n");
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int x : matrix[i]) System.out.print(x + "  ");
            System.out.println();
        }
    }
}
