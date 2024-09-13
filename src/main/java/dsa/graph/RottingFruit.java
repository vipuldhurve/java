package dsa.graph;

import java.util.LinkedList;
import java.util.Queue;
import dsa.util.Print;

public class RottingFruit {
//    You are given a 2-D matrix grid. Each cell can have one of three possible values:

//    0 representing an empty cell
//    1 representing a fresh fruit
//    2 representing a rotten fruit

//    Every minute, if a fresh fruit is horizontally or vertically adjacent to a rotten fruit,
//    then the fresh fruit also becomes rotten.

//    Return the minimum number of minutes that must elapse
//    until there are zero fresh fruits remaining.
//    If this state is impossible within the grid, return -1.

//    Example 1:
//    Input: grid = [[1,1,0],[0,1,1],[0,1,2]]
//    Output: 4

//    Example 2:
//    Input: grid = [[1,0,1],[0,2,0],[1,0,1]]
//    Output: -1

    private static int orangesRotting(int[][] grid) {
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();

//        Add rotten fruit in queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                if(grid[i][j] == 2) queue.add(new int[]{i, j});
        }

//        Neighbor directions
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

//        Start traversing: BFS
        while (!queue.isEmpty()) {
//            Each level will take +1 minute for fresh fruit to become rotten
//            Mark level size
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
//                poll rotten fruit from queue
                int[] cell = queue.poll();
                for (int[] direction : directions) {
                    int newRow = cell[0] + direction[0];
                    int newCol = cell[1] + direction[1];
//                    If neighbor cell has fresh fruit
                    if (newRow >= 0 && newRow < grid.length
                            && newCol >= 0 && newCol < grid[0].length
                            && grid[newRow][newCol] == 1) {
                        queue.add(new int[]{newRow, newCol});
//                        fresh fruit becomes rotten
                        grid[newRow][newCol] = 2;
                    }
                }
            }
//            If another level of rotten fruits added
            if (queue.size() > 0) minutes++;
        }

//        Check if any fresh fruit left in grid
        for (int[] fruits : grid) {
            for (int fruit : fruits) if (fruit == 1) return -1;
        }

        return minutes;
    }

    private static void solve(int[][] grid) {
        System.out.println("INPUT: ");
        Print.intMatrix(grid);
        System.out.println("OUTPUT: " + orangesRotting(grid) + "\n");
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 0},
                {0, 1, 1},
                {0, 1, 2}
        };
        solve(grid);

        grid = new int[][]{
                {1, 0, 1},
                {0, 2, 0},
                {1, 0, 1}
        };
        solve(grid);
    }
}
