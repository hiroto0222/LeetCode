/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
         * start from (0,0).
         * can only move down or right.
         * path cannot contain obstacles.
         * return number of unique paths.
         *
         * intution:
         * dp
         *
         * O(N) time, O(N) space
         */

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if obstacle, update number of paths to 0.
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                // if not obstacle and start point, update number of paths to 1.
                if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                    continue;
                }
                // if neither dp[i][j] = dp[i - 1][j] + dp[i][j - 1] (top + left)
                int top = i == 0 ? 0 : obstacleGrid[i - 1][j];
                int left = j == 0 ? 0 : obstacleGrid[i][j - 1];
                obstacleGrid[i][j] = top + left;
            }
        }

        return obstacleGrid[m - 1][n - 1];
    }
}
// @lc code=end
