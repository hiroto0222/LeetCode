#
# @lc app=leetcode id=62 lang=python3
#
# [62] Unique Paths
#


# @lc code=start
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        given m x n reach (m, n)
        can only move
        1. down
        2. right

        dp[m][n] = dp[m - 1][n] + dp[m][n - 1]
        only 1 way to reach first row, first col
        """

        dp = [[0]]


# @lc code=end
