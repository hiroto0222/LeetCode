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
         * can start from index 0 or index 1
         *
         * intuition:
         * bottom-up dp
         * dp[i] = cost[i] + min(dp[i - 1], dp[i - 2])
         *
         * O(N) time, O(1) space
         */

        int n = cost.length;

        // base cases
        int prev = cost[0];
        int curr = cost[1];

        for (int i = 2; i <= n; i++) {
            int c = i == n ? 0 : cost[i];
            int temp = curr;
            curr = c + Math.min(prev, curr);
            prev = temp;
        }

        return curr;
    }
}
// @lc code=end
