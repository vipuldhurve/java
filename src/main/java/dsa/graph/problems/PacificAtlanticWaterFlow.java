package dsa.graph.problems;

import java.util.*;

import dsa.util.Print;

public class PacificAtlanticWaterFlow {
//    There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
//    The Pacific Ocean touches the island's left and top edges,
//    and the Atlantic Ocean touches the island's right and bottom edges.

//    The island is partitioned into a grid of square cells.
//    You are given an m x n integer matrix heights where
//    heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

//    The island receives a lot of rain, and the rain water can flow to neighboring cells
//    directly north, south, east, and west
//    if the neighboring cell's height is less than or equal to the current cell's height.
//    Water can flow from any cell adjacent to an ocean into the ocean.

//    Return a 2D list of grid coordinates result
//    where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci)
//    to both the Pacific and Atlantic oceans.

//    Example 1:
//    Input: heights = [
//    [1,2,2,3,5],
//    [3,2,3,4,4],
//    [2,4,5,3,1],
//    [6,7,1,4,5],
//    [5,1,1,2,4]]
//    Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

//    Example 2:
//    Input: heights = [[1]]
//    Output: [[0,0]]
//    Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.

    //    TIME COMPLEXITY: O(M*N)   | SPACE COMPLEXITY: O(M*N)
    private static void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m = heights.length, n = heights[0].length;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] direction : directions) {
                int newRow = r + direction[0];
                int newCol = c + direction[1];
//                Check if possible to traverse neighbour cells
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                        && !visited[newRow][newCol]
                        && heights[newRow][newCol] >= heights[r][c]) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    private static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

//        Marking true for cells if possible to reach pacific and atlantic
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

//        Queue for both pacific and atlantic BFS
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            // All left-most cells will be true for pacific
            pacificQueue.offer(new int[]{i, 0});
            pacific[i][0] = true;
            // All right-most cells will be true for atlantic
            atlanticQueue.offer(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            // All top-most cells will be true for pacific
            pacificQueue.offer(new int[]{0, j});
            pacific[0][j] = true;
            // All bottom-most cells will be true for atlantic
            atlanticQueue.offer(new int[]{m - 1, j});
            atlantic[m - 1][j] = true;
        }

        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return result;
    }

    private static void solve(int[][] heights) {
        System.out.println("Input: ");
        Print.print2DArray(heights);
        System.out.println("Output: " + pacificAtlantic(heights) + "\n");
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        solve(input);

        input = new int[][]{{1}};
        solve(input);
    }
}
