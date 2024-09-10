package dsa.backtracking;

import java.awt.*;

public class ValidSudoku1 {
//    VALID SUDOKU BOARD:
//    You need to check if given sudoku board is valid sudoku or not
//    irrespective if it is not solvable

//    Determine if a 9 x 9 Sudoku board is valid.
//    Only the filled cells need to be validated according to the following rules:

//    1. Each row must contain the digits 1-9 without repetition.
//    2. Each column must contain the digits 1-9 without repetition.
//    3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
//    without repetition.

//    NOTE:
//    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//    Only the filled cells need to be validated according to the mentioned rules.

//    Example: Below is a VALID PARTIALLY FILLED SUDOKU BOARD and should return true
//    [
//            [".","8","7","6","5","4","3","2","1"],
//            ["2",".",".",".",".",".",".",".","."],
//            ["3",".",".",".",".",".",".",".","."],
//            ["4",".",".",".",".",".",".",".","."],
//            ["5",".",".",".",".",".",".",".","."],
//            ["6",".",".",".",".",".",".",".","."],
//            ["7",".",".",".",".",".",".",".","."],
//            ["8",".",".",".",".",".",".",".","."],
//            ["9",".",".",".",".",".",".",".","."]
//    ]
//    Output: TRUE

    //    TIME COMPLEXITY: O(N^3)
//    O(N^2) for isValidSudoku1 and O(N) for is Safe
//    In worst case we check all values of board N*N and N=9 for standard sudoku
//    O(N^2)*O(N) => (N^3) => O(729)
//    => O(1)
    private static boolean isSafe(char[][] board, int row, int col) {
        char cellValue = board[row][col];
//        Check row and column
        for (int i = 0; i < board.length; i++) {
//            Check if current cell value is present in same row or column
//            Skip same [row][col] cell
            if (i != col && board[row][i] == cellValue) return false;
            if (i != row && board[i][col] == cellValue) return false;
        }
//        Check in same block
        int blockStartRow = (row / 3) * 3;
        int blockStartCol = (col / 3) * 3;
        for (int i = blockStartRow; i < blockStartRow + 3; i++) {
            for (int j = blockStartCol; j < blockStartCol + 3; j++) {
//                Skip same [row][col] cell
                if (i != row && j != col && board[i][j] == cellValue) return false;
            }
        }
        return true;
    }

    private static boolean isValidSudoku1(char[][] board, int row, int col) {
//        If safely checked all cells
        if (row == board.length) return true;

//        Calculate next row and column
        int nextRow, nextCol;
        if (col != board.length - 1) {
            nextRow = row;
            nextCol = col + 1;
        } else {
            nextRow = row + 1;
            nextCol = 0;
        }

//        If cell empty continue checking next cell
//        If cell has value check if valid or not
        if (board[row][col] == '.' || isSafe(board, row, col)) {
            return isValidSudoku1(board, nextRow, nextCol);
        } else return false;
    }

    private static void solve(char[][] board) {
        System.out.println("Input: ");
        for (char[] row : board) {
            for (char c : row) System.out.print(c + "   ");
            System.out.println();
        }
        System.out.println("Output: " + String.valueOf(isValidSudoku1(board, 0, 0)).toUpperCase() + "\n");
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '1', '2', '3', '4', '5', '6', '7', '8'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        solve(board);

        board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solve(board);

        board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solve(board);
    }

}
