package dsa.backtracking;

public class ValidSudoku2 {
//    VALID SUDOKU SOLUTION:
//    You need to check if given sudoku board is valid sudoku and possible solution exists
//    If exists a possible solution print it

//    Determine if a 9 x 9 Sudoku board is valid.
//    Only the filled cells need to be validated according to the following rules:

//    1. Each row must contain the digits 1-9 without repetition.
//    2. Each column must contain the digits 1-9 without repetition.
//    3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
//    without repetition.

//    Example: It is not possible to solve the below sudoku
//    Below is a INVALID SUDOKU and should return false
//
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
//    Output: FALSE


    //    TIME COMPLEXITY: O(9^(N*N))
//    worst case i.e. when all cells are empty, and we try all 9 values for each cell
    private static boolean isSafe(char[][] board, int row, int col, int value) {
//        Convert int to char
        char charValue = (char) (value + '0');
//        Check row and column
        for (int i = 0; i < board.length; i++) {
//            Check if value is present in same row or column
            if (board[row][i] == charValue || board[i][col] == charValue) return false;
        }
//        Check in same block
        int blockStartRow = (row / 3) * 3;
        int blockStartCol = (col / 3) * 3;
        for (int i = blockStartRow; i < blockStartRow + 3; i++) {
            for (int j = blockStartCol; j < blockStartCol + 3; j++) {
                if (board[i][j] == charValue) return false;
            }
        }
        return true;
    }

    private static boolean isValidSudoku2(char[][] board, int row, int col) {
//        If safely filled all cells
        if (row == board.length) return true;

//        Calculate next row and col
        int nextRow, nextCol;
        if (col != board.length - 1) {
            nextRow = row;
            nextCol = col + 1;
        } else {
            nextRow = row + 1;
            nextCol = 0;
        }

//        If cell empty call is Valid Sudoku to place values from 1 to 9
        if (board[row][col] != '.') {
            if (isValidSudoku2(board, nextRow, nextCol)) return true;
        } else {
            for (int val = 1; val <= 9; val++) {
                if (isSafe(board, row, col, val)) {
                    board[row][col] = (char) (val + '0');
                    if (isValidSudoku2(board, nextRow, nextCol)) return true;
                    else board[row][col] = '.';
                }
            }
        }
        return false;
    }

    private static void solve(char[][] board) {
        System.out.println("INPUT: ");
        for (char[] row : board) {
            for (char c : row) System.out.print(c + "   ");
            System.out.println();
        }
        boolean isValid = isValidSudoku2(board, 0, 0);
        System.out.println("IS VALID?: " + String.valueOf(isValid).toUpperCase() + "\n");
        if (isValid) {
            System.out.println("SOLVED:");
            for (char[] row : board) {
                for (char c : row) System.out.print(c + "   ");
                System.out.println();
            }
        }
        System.out.println("\n" + "---------------------------------------");
        System.out.println("\n");
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
