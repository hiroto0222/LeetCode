/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        /*
         * return min cost to reach top floor
         * can climb 1 or 2 steps
         *
         * intuition:
         * - we want to know mincost to reach n
         * - mincost(n) would relate to mincost(n - 1) and mincost(n - 2)
         * - base cases are
         * - dp[0] = cost[0]
         * - dp[1] = cost[1]
         * ...
         * - dp[n] = min(dp[n - 2], dp[n - 1])
         * - bottom-up dp
         *
         * O(N) time, O(N) space
         */

        int n = cost.length;
        int[] dp = new int[n];
        // base case
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
// @lc code=end
