#
# @lc app=leetcode id=122 lang=python3
#
# [122] Best Time to Buy and Sell Stock II
#


# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # prices = [7,1,5,3,6,4]
        # can buy and sell immediately
        # [1,5,10,2]
        # 1. buy 1 -> sell at 5, buy 5 -> sell at 10 = 9
        # 2. buy 1 -> sell at 10 = 9
        # if increasing, always sell
        # if only 1 price, profit is 0

        n = len(prices)
        ans = 0
        for i in range(1, n):
            if prices[i - 1] < prices[i]:
                ans += prices[i] - prices[i - 1]

        return ans


# @lc code=end
