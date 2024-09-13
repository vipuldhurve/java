package dsa.graph;

import java.util.Scanner;

public class CountingRooms {

    public static int[][] graph;
    public static boolean[][] visited;
    public static int m, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int j = 0;
            for (char c : s.toCharArray()) {
                if (c == '.') graph[i][j] = 1;
                j++;
            }
        }
        System.out.println(countRooms());
    }

    public static int countRooms() {
        int rooms = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    rooms++;
                }
            }
        }
        return rooms;
    }

    public static void dfs(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m) return;
        if (graph[row][col] == 0) return;
        if (visited[row][col]) return;

        visited[row][col] = true;
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}

