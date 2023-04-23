#
# @lc app=leetcode id=120 lang=python3
#
# [120] Triangle
#


# @lc code=start
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        """
        return min path sum from top to bottom

        top-down dfs with memoization
        1. h + 1, i
        2. h + 1, i + 1

        time -> O(N^2)
        space -> O(N*(1 + 2 + 3 + ... N) = N^2)
        """
        n = len(triangle)
        cache = {}

        def dfs(h, i):
            if h >= n or i >= len(triangle[h]):
                return 0

            if (h, i) in cache:
                return cache[(h, i)]

            res = min(
                triangle[h][i] + dfs(h + 1, i + 1),
                triangle[h][i] + dfs(h + 1, i),
            )
            cache[(h, i)] = res
            return res

        return dfs(0, 0)


# @lc code=end
