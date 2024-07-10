/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start

class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
         * return fewest number of coins needed to make amount.
         * assume infinite number of each coin.
         *
         * intuition:
         * - recursive dp with cache.
         * - dp of {amount -> minLength}
         *
         * O(N * M) time, O(N) space
         */

        Integer[] dp = new Integer[amount + 1];
        return dfs(coins, amount, dp);
    }

    private int dfs(int[] coins, int amount, Integer[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (dp[amount] != null) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, amount - coin, dp);

            if (res >= 0 && res < minCoins) {
                minCoins = 1 + res;
            }
        }

        dp[amount] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return dp[amount];
    }
}
// @lc code=end
