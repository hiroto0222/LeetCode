#
# @lc app=leetcode id=279 lang=python3
#
# [279] Perfect Squares
#

# @lc code=start
class Solution:
    def numSquares(self, n: int) -> int:
        dp = [n] * (n + 1)
        dp[0] = 0
        squares = [x**2 for x in range(0, n) if x**2 <= n]

        for target in range(1, n + 1):
            for square in squares:
                if target - square < 0:
                    break
                dp[target] = min(dp[target], 1 + dp[target - square])
        
        return dp[n]
        
# @lc code=end

