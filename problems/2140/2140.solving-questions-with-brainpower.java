/*
 * @lc app=leetcode id=2140 lang=java
 *
 * [2140] Solving Questions With Brainpower
 */

// @lc code=start
class Solution {
    public long mostPoints(int[][] questions) {
        /*
         * return max points earned in exam.
         *
         * intuition:
         * - bottom-up dp
         * - dp[i] = max(dp[i + 1], dp[i + braini + 1] + pointsi)
         *
         * O(N) time, O(N) space
         */

        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];

        for (int i = n - 2; i >= 0; i--) {
            long next = 0;
            if (i + questions[i][1] + 1 < n) {
                next = dp[i + questions[i][1] + 1];
            }
            // max of skip or solve current
            dp[i] = Math.max(dp[i + 1], questions[i][0] + next);
        }

        return dp[0];
    }
}
// @lc code=end
