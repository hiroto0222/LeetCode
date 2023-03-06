#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        # dp[i] = dp[i - 1] + dp[i - 2]
        # dp = [0, 1, 2]

        dp = [1] * (n + 1)

        for i in range(2, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]

        return dp[n]


# @lc code=end
