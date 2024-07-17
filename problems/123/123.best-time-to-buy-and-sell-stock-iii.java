/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        /*
         * find the max profit achievable in at most 2 transactions.
         * must sell before buying.
         *
         * intuition:
         * - recursive top-down dp
         * - state -> [0,1,2,3,4] where even -> need to buy, odd -> need to sell
         * - dp[i][state] -> max profit achievable starting from i and state
         *
         * O(N) time, O(N) space.
         */

        dp = new Integer[prices.length][5];
        int res = helper(prices, 0, 0);
        return Math.max(res, 0);
    }

    private int helper(int[] prices, int i, int state) {
        // have already made 2 transactions, so return.
        if (state == 4) {
            return 0;
        }
        // end of prices, but still need to buy.
        if (i == prices.length - 1 && state % 2 == 0) {
            return Integer.MIN_VALUE;
        }
        if (i == prices.length - 1) {
            return prices[i];
        }
        // if already computed, return that
        if (dp[i][state] != null) {
            return dp[i][state];
        }
        // if even we need to buy, if odd we need to sell.
        int curr = (state % 2 == 0) ? -prices[i] : prices[i];
        // 2 choices of hold, or buy/sell
        int res = Math.max(
                helper(prices, i + 1, state),
                curr + helper(prices, i + 1, state + 1));

        if (state == 1) {
            res = Math.max(res, prices[i]);
        }

        dp[i][state] = res;
        return dp[i][state];
    }
}
// @lc code=end
