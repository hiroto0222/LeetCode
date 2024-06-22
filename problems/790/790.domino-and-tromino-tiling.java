/*
 * @lc app=leetcode id=790 lang=java
 *
 * [790] Domino and Tromino Tiling
 */

// @lc code=start
class Solution {
    public int numTilings(int n) {
        /*
         * number of ways to tile an 2 x n board
         * - we have 2 types of blocks L shaped, 1x2
         *
         * consider the 4 sub-problems for nth case
         * 1. we add vertical line at n
         * 2. we add 2 horizontal lines at n
         * 3. we add 1 tromino with 1 gap at top n - 1
         * 3. we add 1 tromino with 1 gap at bottom n - 1
         *
         * full[n] = full[n - 1] + full[n - 2]
         * + topMissing[n - 1] + bottomMissing[n - 1]
         * where
         * topMissing[n] = bottomMissing[n - 1] + full[n - 2]
         * bottomMissing[n] = topMissing[n - 1] + full[n - 2]
         *
         * base cases
         * full[0] = 1, full[1] = 1
         * topMissing[1] = 0
         * bottomMissing[1] = 0
         */

        long[] dp = new long[n + 2];
        dp[0] = 1;
        dp[1] = 2;
        long[] dpa = new long[n + 2];
        dpa[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dpa[i - 1] * 2) % 1000000007;
            dpa[i] = (dp[i - 2] + dpa[i - 1]) % 1000000007;
        }
        return (int) dp[n - 1];
    }
}
// @lc code=end
