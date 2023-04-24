#
# @lc app=leetcode id=931 lang=python3
#
# [931] Minimum Falling Path Sum
#


# @lc code=start
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        """
        top-down memoization
        """

        N = len(matrix)
        dp = {}

        def dfs(i, j):
            if j < 0 or j >= len(matrix[i]):
                return float("inf")

            if i == N - 1:
                return matrix[i][j]

            if (i, j) in dp:
                return dp[(i, j)]

            res = matrix[i][j]
            res += min(dfs(i + 1, j - 1), dfs(i + 1, j), dfs(i + 1, j + 1))
            dp[(i, j)] = res
            return res

        res = float("inf")
        for j in range(N):
            res = min(res, dfs(0, j))

        return res


# @lc code=end
