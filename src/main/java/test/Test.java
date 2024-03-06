package test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int n = 10;
        for(int i=0; i<n; i++){
            for(int j=0; j < i; j++){
                // j is dependent on i
            }
        }

    }

    public boolean isValidSudoku(char[][] board) {
        HashMap<String, HashSet<Character>> map = new HashMap<>();
        int m = board.length;
        int n = board[0].length;

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                char c = board[i][j];
                if(c == '.') continue;
                //row check
                String key = "r" + i;
                if(map.get(key).contains(c)){
                    return false;
                } else {
                    map.get(key).add(c);
                }

                //col check
                key = "c" + j;
                if(map.get(key).contains(c)){
                    return false;
                } else {
                    map.get(key).add(c);
                }

                //box check
                key = "r" + i/3 + "c" + j/3;
                if(map.get(key).contains(c)){
                    return false;
                } else {
                    map.get(key).add(c);
                }
            }
        }
        return true;
    }
}




