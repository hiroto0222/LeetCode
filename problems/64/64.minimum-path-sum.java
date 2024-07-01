/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 */

// @lc code=start

class Solution {
    public int minPathSum(int[][] grid) {
        /*
         * given m x n grid, find minimum path
         *
         * intuition:
         * min path at (i,j) is
         * dp[i][j] = grid[i][j] + min(dp[i - 1][j], dp[i][j - 1])
         * use input grid as dp matrix
         *
         * O(N*M) time, O(1) space
         */

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    grid[i][j] += j == 0 ? 0 : grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}
// @lc code=end
