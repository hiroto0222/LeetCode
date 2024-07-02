/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        /*
         * given nxn matrix, return min sum of any falling path.
         * start from the first row and col.
         * (row, col) -> (row + 1, col - 1), (row + 1, col), (row + 1, col + 1)
         * -100 <= matrix[row][col] <= 100
         *
         * intuition:
         * for each row find the optimal minimum paths from each branch.
         * bottom-up dp
         *
         * O(N*N) time, O(N*N) space
         */

        int n = matrix.length;
        int[][] dp = new int[n][n];

        // fill base case
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int i = 0; i < n; i++) {
                int left = i == 0 ? dp[row + 1][i] : dp[row + 1][i - 1];
                int right = i == n - 1 ? dp[row + 1][i] : dp[row + 1][i + 1];
                dp[row][i] = matrix[row][i] + Math.min(dp[row + 1][i], Math.min(left, right));
            }
        }

        int res = dp[0][0];
        for (int i = 1; i < n; i++) {
            if (dp[0][i] < res) {
                res = dp[0][i];
            }
        }

        return res;
    }
}
// @lc code=end
