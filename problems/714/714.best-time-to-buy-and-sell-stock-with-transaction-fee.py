#
# @lc app=leetcode id=714 lang=python3
#
# [714] Best Time to Buy and Sell Stock with Transaction Fee
#


# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        """
        pay fee for each buy + sell
        maximize profit

        for each day can buy, sell or do nothing
        1. if havent bought anything, need to buy
            1. buy prices[i] -> -prices[i] + F(i + 1, sell)
            2. dont buy prices[i] -> F(i + 1, buy)
        2. if have bought, need to sell
            1. sell at prices[i] -> prices[i] - fee + F(i + 1, buy)
            2. dont sell at prices[i] -> F(i + 1, sell)

        top-down
        """
        n = len(prices)
        dp = {}

        def helper(i, sell):
            # base case
            if i >= n:
                return 0
            if (i, sell) in dp:
                return dp[(i, sell)]

            res = 0
            if not sell:
                res = max(
                    -prices[i] + helper(i + 1, not sell), helper(i + 1, sell)
                )
            if sell:
                res = max(
                    prices[i] - fee + helper(i + 1, not sell),
                    helper(i + 1, sell),
                )
            dp[(i, sell)] = res
            return res

        return helper(0, False)


# @lc code=end
