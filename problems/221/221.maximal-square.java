/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        /*
         * given m x n matrix, find largest square containing only 1s.
         * return its area.
         * 1 <= m, n <= 300
         *
         * intuition:
         * - bottom-up dp
         * - dp(i,j) = grid(i,j) + min(dp(i+1,j), dp(i+1,j+1), dp(i,j+1))
         * - for each cell, check curr maximal side of square
         *
         * O(N*M) time, O(N*M) space
         */

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }

                if (j == n - 1 || i == m - 1) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    dp[i][j] = (matrix[i][j] - '0') + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
                }

                if (dp[i][j] > maxSide) {
                    maxSide = dp[i][j];
                }
            }
        }

        return maxSide * maxSide;
    }
}
// @lc code=end
