#
# @lc app=leetcode id=54 lang=python3
#
# [54] Spiral Matrix
#


# @lc code=start
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        # keep track of l, r columns and t, d rows

        l, r, t, d = 0, len(matrix[0]) - 1, 0, len(matrix) - 1
        res = []

        while l <= r and t <= d:
            # top row
            for i in range(l, r + 1):
                res.append(matrix[t][i])
            t += 1
            if t > d:
                break

            # right column
            for i in range(t, d + 1):
                res.append(matrix[i][r])
            r -= 1
            if r < l:
                break

            # bottom row
            for i in range(r, l - 1, -1):
                res.append(matrix[d][i])
            d -= 1
            if d < t:
                break

            # left column
            for i in range(d, t - 1, -1):
                res.append(matrix[i][l])
            l += 1
            if l > r:
                break

        return res


# @lc code=end
