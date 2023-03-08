#
# @lc app=leetcode id=121 lang=python3
#
# [121] Best Time to Buy and Sell Stock
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # choose single day to buy and sell stock and return max profit
        # prices = [7, 1, 5, 3, 6, 4] -> buy 1 sell 6 -> 5
        # if cost is lower, buy
        # if cost is higher, keep selling -> obtain max from that
        # O(N) time, O(1) space
        
        curr_max = 0
        curr = prices[0]
        for i in range(1, len(prices)):
            if prices[i] < curr:
                curr = prices[i]
            else:
                curr_max = max(curr_max, prices[i] - curr)

        return curr_max

        
# @lc code=end
