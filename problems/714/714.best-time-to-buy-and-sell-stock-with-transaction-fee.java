/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        /*
         * maximum profit
         * must pay transaction fee
         * must sell before buying again
         *
         * [1,3,2,8,4,9], fee = 2
         * ((8 - 1) - 2) + ((9 - 4) - 2) = 8
         *
         * intuition:
         * consider 2 states
         * 1. needs to buy, can wait or sell
         * 2. needs to sell, can wait or buy
         *
         * considering a graph DS with 2 states.
         * find the maximum path.
         *
         * for each node, find the max path to such node from the 2 different states
         *
         * O(N) time, O(N) space
         */

        int n = prices.length;

        int[] toBuy = new int[n]; // toBuy[i] = max(toBuy[i - 1], toSell[i - 1] + prices[i])
        int[] toSell = new int[n]; // toSell[i] = max(toSell[i - 1], toBuy[i - 1] - prices[i] - 2)

        toBuy[0] = 0;
        toSell[0] = -prices[0] - fee;

        for (int i = 1; i < n; i++) {
            toBuy[i] = Math.max(toBuy[i - 1], toSell[i - 1] + prices[i]); // wait or sells holding stock
            toSell[i] = Math.max(toSell[i - 1], toBuy[i - 1] - prices[i] - fee); // wait or buy new stock
        }

        return Math.max(toBuy[n - 1], toSell[n - 1]);
    }

    public int maxProfit2(int[] prices, int fee) {
        /*
         * only depends on previous toBuy, toSell state
         *
         * O(N) time, O(1) space
         */

        int n = prices.length;

        int toBuy = 0;
        int toSell = -prices[0] - fee;

        for (int i = 1; i < n; i++) {
            int prevToBuy = toBuy, prevToSell = toSell;
            toBuy = Math.max(prevToBuy, prevToSell + prices[i]); // wait or sells holding stock
            toSell = Math.max(prevToSell, prevToBuy - prices[i] - fee); // wait or buy new stock
        }

        return Math.max(toBuy, toSell);
    }
}
// @lc code=end
