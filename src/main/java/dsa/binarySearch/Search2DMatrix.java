package dsa.binarySearch;

public class Search2DMatrix {
//    You are given an m x n 2-D integer array matrix and an integer target.

//    1. Each row in matrix is sorted in non-decreasing order.
//    2. The first integer of every row is greater than
//    the last integer of the previous row.

//    Return true if target exists within matrix or false otherwise.

//    Input: matrix =
//    [[1,2,4,8],
//    [10,11,12,13],
//    [14,20,30,40]], target = 10
//    Output: true

//    Input: matrix =
//    [[1,2,4,8]
//    ,[10,11,12,13],
//    [14,20,30,40]], target = 15
//    Output: false

//    Input matrix=
//    [[1,3,5,7],
//    [10,11,16,20],
//    [23,30,34,60]] target=3
//    Output: true


    private static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int i = 0;
        int j = matrix[0].length - 1;
        while (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }

    private static void solve(int[][] matrix, int target) {
        System.out.println("INPUT:");
        for (int[] row : matrix) {
            for (int col : row) System.out.print(col + " ");
            System.out.println();
        }
        System.out.println("TARGET: " + target);
        System.out.println("OUTPUT: " + searchMatrix(matrix, target) + "\n");
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 4, 8},
                {10, 11, 12, 13},
                {14, 20, 30, 40}
        };
        int target = 10;
        solve(matrix, target);

        target = 15;
        solve(matrix, target);

        matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        target = 3;
        solve(matrix, target);

        solve(new int[][]{}, 0);
    }
}
