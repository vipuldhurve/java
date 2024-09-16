package dsa.mathAndGeometry;

import dsa.util.Printer;

public class RotateMatrix {
//    Given a square n x n matrix of integers matrix,
//    rotate it by 90 degrees clockwise.

//    You must rotate the matrix in-place.
//    Do not allocate another 2D matrix and do the rotation.

//    ------------------ For 90 degree Clockwise Rotation --------------------
//    Input: matrix =
//              0  1  2
//         0   [1, 2, 3],
//         1   [4, 5, 6],
//         2   [7, 8, 9]

//    Output:   0  1  2
//         0   [7, 4, 1],
//         1   [8, 5, 2],
//         2   [9, 6, 3]

//    On observation each row is converted to a column
//    So we can transpose the matrix to convert row to column
//              0  1  2
//         0   [1, 4, 7],
//         1   [2, 5, 8],
//         2   [3, 6, 9]

    //    Above transpose matrix has rows in reverse of output.
//    So we can reverse the rows of transpose matrix to get output
    private static void rotateMatrixClockwise(int[][] matrix) {
        int n = matrix.length;

//        Transpose matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

//        Reverse rows of transpose matrix
        for (int row = 0; row < n; row++) {
            int start = 0, end = n - 1;
//            Reverse each row using 2 pointer
            while (start < end) {
                int temp = matrix[row][start];
                matrix[row][start] = matrix[row][end];
                matrix[row][end] = temp;
                start++;
                end--;
            }
        }
    }

//    ------------------ For 90 degree Anti-Clockwise Rotation --------------------
//    Input: matrix =
//              0  1  2
//         0   [1, 2, 3],
//         1   [4, 5, 6],
//         2   [7, 8, 9]

//    Output:   0  1  2
//         0   [3, 6, 9],
//         1   [2, 5, 8],
//         2   [1, 4, 7]

//    On observation each row is converted to a column
//    So we can transpose the matrix to convert row to column
//              0  1  2
//         0   [1, 4, 7],
//         1   [2, 5, 8],
//         2   [3, 6, 9]

//    Above transpose matrix has columns in reverse of output.
//    So we can reverse the rows of transpose matrix to get output

    private static void rotateMatrixAntiClockwise(int[][] matrix) {
        int n = matrix.length;

//        Transpose matrix
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

//        Reverse columns of transpose matrix
        for (int col = 0; col < n; col++) {
            int start = 0, end = n - 1;
//            Reverse each column using 2 pointer
            while (start < end) {
                int temp = matrix[start][col];
                matrix[start][col] = matrix[end][col];
                matrix[end][col] = temp;
                start++;
                end--;
            }
        }
    }

    private static void solve(int[][] input) {
//        Print input
        System.out.println("------------- INPUT ------------- ");
        Printer.printIntMatrix(input);
//       Rotate Clockwise
        rotateMatrixClockwise(input);
        System.out.println("--------------- Clockwise: ");
        Printer.printIntMatrix(input);
//       Rotate Anti-clockwise
        rotateMatrixAntiClockwise(input);
        rotateMatrixAntiClockwise(input);
        System.out.println("--------------- Anti-clockwise: ");
        Printer.printIntMatrix(input);
        System.out.println("--------------------------------");
        System.out.print("-------------------------------- \n\n\n\n");
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2},
                {3, 4}
        };
        solve(input);

        input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solve(input);

        input = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solve(input);
    }

}
