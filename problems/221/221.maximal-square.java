/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        int[][] dp = new int[ROWS + 1][COLS + 1];
        int res = 0;
        for (int i = 1; i <= ROWS; i++) {
            for (int j = 1; j <= COLS; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int top = dp[i - 1][j];
                    int diag = dp[i - 1][j - 1];
                    int left = dp[i][j - 1];
                    dp[i][j] = Math.min(top, Math.min(diag, left)) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }
}
// @lc code=end
