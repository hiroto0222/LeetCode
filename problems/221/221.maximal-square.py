#
# @lc app=leetcode id=221 lang=python3
#
# [221] Maximal Square
#


# @lc code=start
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        """
        dp
        for every 1 found:
            as if a single 0 exists for left, top, diag left,
            then largest square for (i, j) is 1
            dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
        """

        n, m = len(matrix), len(matrix[0])
        dp = [[0] * (m + 1) for _ in range(n + 1)]

        res = 0
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if matrix[i - 1][j - 1] == "1":
                    dp[i][j] = (
                        min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]) + 1
                    )
                    res = max(res, dp[i][j])

        return res * res


# @lc code=end
