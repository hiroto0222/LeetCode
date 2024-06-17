/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        /*
         * 0 -> empty
         * 1 -> fresh orange
         * 2 -> rotten orange
         * every minute, any fresh orange 4-directionally adjacent to rotten becomes
         * rotten.
         * return min number of mins till no fresh oranges.
         * if impossible, return -1.
         *
         * intuition:
         * - BFS but from every rotten orange
         * - keep track of number of fresh oranges
         * - as visited oranges will be marked as rotten, can keep track within grid
         *
         * O(N * M) time, O(N * M) space
         */

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>(); // keeps track of rotten oranges
        int freshCnt = 0;

        // add all rotten oranges to queue and cnt fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // if rotten
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
                // if fresh
                else if (grid[i][j] == 1) {
                    freshCnt++;
                }
            }
        }

        // if no fresh oranges, then just return 0
        if (freshCnt == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        // BFS and traverse 4 adjacent neighbors from each rotten orange
        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];

                    // check if inbounds and fresh (not visited)
                    if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1) {
                        grid[row][col] = 2; // mark as rotten (and visited)
                        queue.offer(new int[] { row, col });
                        freshCnt--;
                    }
                }
            }
        }

        return freshCnt == 0 ? minutes - 1 : -1;
    }
}
// @lc code=end
