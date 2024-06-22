/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        /*
         * cannot rob from 2 adjacent houses
         * return max amount of money you can rob
         *
         * intuition:
         * - the robber has 2 options, rob curr house, or dont
         * - dp[i] = max(dp[i - 2] + curr, dp[i - 1])
         * - bottom-up dp
         *
         * O(N) time, O(N) space
         */

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        // base cases
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }

        return dp[n];
    }
}
// @lc code=end
