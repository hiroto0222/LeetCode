/*
 * @lc app=leetcode id=1926 lang=java
 *
 * [1926] Nearest Exit from Entrance in Maze
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // up, down, left, right
    final int[][] DIRS = {
            { 0, 1 },
            { 0, -1 },
            { -1, 0 },
            { 1, 0 }
    };

    public int nearestExit(char[][] maze, int[] entrance) {
        /*
         * can move up, down, left, right
         * start from entrance
         * find nearest exit (shortest path), empty cell at the border of the maze.
         * - entrance does not count as exit
         * - if no exit, return -1
         *
         * intuition:
         * - BFS till at border
         * - each level is the number of moves
         */

        int rows = maze.length - 1;
        int cols = maze[0].length - 1;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows + 1][cols + 1];

        q.add(entrance);
        visited[entrance[0]][entrance[1]] = true;

        int currLevel = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] currCell = q.poll();
                int row = currCell[0];
                int col = currCell[1];

                // if exit, return currLevel
                if ((row != entrance[0] || col != entrance[1])
                        && (row == 0 || row == rows || col == 0 || col == cols)) {
                    return currLevel;
                }

                // else add neighbors
                for (int[] dir : DIRS) {
                    int dRow = row + dir[0];
                    int dCol = col + dir[1];
                    if (dRow >= 0 && dRow <= rows && dCol >= 0 && dCol <= cols
                            && maze[dRow][dCol] != '+' && !visited[dRow][dCol]) {
                        q.add(new int[] { dRow, dCol });
                        visited[dRow][dCol] = true;
                    }
                }
            }
            currLevel++; // traverse level
        }

        // no exit found
        return -1;
    }
}
// @lc code=end
