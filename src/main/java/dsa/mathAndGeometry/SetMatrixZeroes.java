package dsa.mathAndGeometry;

public class SetMatrixZeroes {
//    Given an m x n integer matrix matrix, if an element is 0,
//    set its entire row and column to 0's.

//    You must do it in place.

//    Input:
//            [0,1]
//            [1,1]
//    Output:
//            [0,0]
//            [0,1]

//    Input:
//            [1,2,3]
//            [4,0,5]
//            [6,7,8]
//    Output:
//            [1,0,3]
//            [0,0,0]
//            [6,0,8]

    private static void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;

//        Row markers if that row/col has zero to make all values in that row/col = 0
        boolean[] rowMark = new boolean[matrix.length];
        boolean[] colMark = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowMark[i] = true;
                    colMark[j] = true;
                }
            }
        }

        for (int i = 0; i < rowMark.length; i++) {
            if (rowMark[i]) {
                for (int j = 0; j < matrix[i].length; j++) matrix[i][j] = 0;
            }
        }

        for (int j = 0; j < colMark.length; j++) {
            if (colMark[j]) {
                for (int i = 0; i < matrix.length; i++) matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {0, 1},
                {1, 0}
        };
        solveAndPrint(input);

        input = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        solveAndPrint(input);

        input = new int[][]{
                {1, 2, 3},
                {4, 0, 5},
                {6, 7, 8}
        };
        solveAndPrint(input);

        input = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solveAndPrint(input);
    }

    private static void solveAndPrint(int[][] input) {
        System.out.println("----------------- Input: ");
        printMatrix(input);
        System.out.println("----------------- Output: ");
        setZeroes(input);
        printMatrix(input);
        System.out.println("--------------------------------");
        System.out.print("-------------------------------- \n\n\n\n");
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int x : matrix[i]) System.out.print(x + "   ");
            System.out.println();
        }
    }
}
