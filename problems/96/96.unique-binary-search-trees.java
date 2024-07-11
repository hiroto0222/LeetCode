/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        /*
         * given number of nodes n, return number of unique BSTs.
         * BST contains n nodes of unique values from 1 to n.
         *
         * intuition:
         * - formula as follows:
         * - dp[n] = sum(dp[n - 1 - i] * dp[i]) where i = [0, n - 1]
         * - base cases:
         * - dp[0] = 1
         * - dp[1] = 1
         *
         * O(N) time, O(N) space
         */

        int[] dp = new int[n + 1];
        // base cases
        dp[0] = 1;
        dp[1] = 1;

        // k is number of nodes of BST.
        for (int k = 2; k <= n; k++) {
            int cnt = 0;
            for (int i = 0; i <= k - 1; i++) {
                cnt += dp[k - 1 - i] * dp[i];
            }
            dp[k] = cnt;
        }

        return dp[n];
    }
}
// @lc code=end
