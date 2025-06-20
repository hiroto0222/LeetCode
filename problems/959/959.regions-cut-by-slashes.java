/*
 * @lc app=leetcode id=959 lang=java
 *
 * [959] Regions Cut By Slashes
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[][] DIRS = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    public int regionsBySlashes(String[] grid) {
        // remap from 1x1 cell to 3x3 cell
        // BFS to count regions

        int n = grid.length;
        int[][] expandedGrid = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int baseRow = i * 3;
                int baseCol = j * 3;
                if (grid[i].charAt(j) == '\\') {
                    expandedGrid[baseRow][baseCol] = 1;
                    expandedGrid[baseRow + 1][baseCol + 1] = 1;
                    expandedGrid[baseRow + 2][baseCol + 2] = 1;
                } else if (grid[i].charAt(j) == '/') {
                    expandedGrid[baseRow][baseCol + 2] = 1;
                    expandedGrid[baseRow + 1][baseCol + 1] = 1;
                    expandedGrid[baseRow + 2][baseCol] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (expandedGrid[i][j] == 0) {
                    // fill region and count
                    floodFill(expandedGrid, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void floodFill(int[][] expandedGrid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        expandedGrid[row][col] = 1;
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : DIRS) {
                int nextRow = curr[0] + dir[0];
                int nextCol = curr[1] + dir[1];
                
                if (isValidCell(expandedGrid, nextRow, nextCol)) {
                    expandedGrid[nextRow][nextCol] = 1;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }

    private boolean isValidCell(int[][] expandedGrid, int row, int col) {
        int n = expandedGrid.length;
        return (
            row >= 0 &&
            col >= 0 &&
            row < n &&
            col < n &&
            expandedGrid[row][col] == 0
        );
    }
}
// @lc code=end

