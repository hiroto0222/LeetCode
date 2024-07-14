/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        /*
         * return number of combinations of coins that make up amount.
         * not permutations so [1,2,1] and [1,1,2] are the same.
         *
         * intuition:
         * - bottom up dp where dp[i] -> number of ways to make i.
         * - must avoid permutations, so iterate from each coin and update dp.
         * - dp[i] = dp[i] + dp[i - coin]
         *
         * O(N * M) time, O(M) space. where M = amount.
         */

        int[] dp = new int[amount + 1];
        dp[0] = 1; // base case

        for (int coin : coins) {
            // iterate over different amounts for curr coin.
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }

        return dp[amount];
    }
}
// @lc code=end
