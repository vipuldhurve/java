package cses.graphs;

import java.util.Scanner;

public class CountingRooms {

    public static int[][] A;
    public static boolean[][] visited;
    public static int m,n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        A = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            String s = sc.nextLine();
            int j=0;
            for(char c: s.toCharArray()){
                if(c == '.') A[i][j] = 1;
                j++;
            }
        }
        System.out.println(countRooms());
    }

    public static int countRooms(){
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(A[i][j] == 1 && !visited[i][j]){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int r, int c){
        if(r<0 || r>=m) return;
        if(c<0 || c>=n) return;
        if(A[r][c] == 0) return;
        if(visited[r][c]) return;


        visited[r][c] = true;
        dfs(r+1, c);
        dfs(r, c+1);
        dfs(r-1, c);
        dfs(r, c-1);
    }


}

