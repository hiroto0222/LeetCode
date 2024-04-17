#
# @lc app=leetcode id=121 lang=python3
#
# [121] Best Time to Buy and Sell Stock
#


# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # prices = [7,1,5,3,6,4]
        # always buy lower price
        # if price is higher, sell and compare with current max

        n = len(prices)

        if n == 0:
            return 0

        curr_max = 0
        curr_price = prices[0]
        for i in range(1, n):
            if prices[i] < curr_price:
                # buy for lower price, dont sell
                curr_price = prices[i]
            else:
                # compare sell price with curr_max
                curr_max = max(curr_max, prices[i] - curr_price)

        return curr_max


# @lc code=end
