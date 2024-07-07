/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        /*
         * if you sell a stock, you cannot buy stock on the next day.
         * return max profit achievable.
         *
         * intuition:
         * - 2 states, buying or selling.
         * - if buy -> i + 1
         * - if sell -> i + 2 (for cooldown)
         *
         * O(2^N) time without caching.
         * O(N) time with caching, O(N) space.
         */

        int n = prices.length;
        Integer[][] dp = new Integer[n][2];

        return dfs(0, true, prices, dp);
    }

    private int dfs(int i, boolean isBuying, int[] prices, Integer[][] dp) {
        if (i >= prices.length) {
            return 0;
        }
        // if already seen
        if (dp[i][isBuying ? 1 : 0] != null) {
            return dp[i][isBuying ? 1 : 0];
        }
        // if isBuying, can buy or can cooldown
        if (isBuying) {
            int buy = dfs(i + 1, !isBuying, prices, dp) - prices[i];
            int cool = dfs(i + 1, isBuying, prices, dp);
            dp[i][isBuying ? 1 : 0] = Math.max(cool, buy);
        }
        // else, sell or cooldown
        else {
            int sell = dfs(i + 2, !isBuying, prices, dp) + prices[i];
            int cool = dfs(i + 1, isBuying, prices, dp);
            dp[i][isBuying ? 1 : 0] = Math.max(sell, cool);
        }

        return dp[i][isBuying ? 1 : 0];
    }
}
// @lc code=end
