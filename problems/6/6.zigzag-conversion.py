#
# @lc app=leetcode id=6 lang=python3
#
# [6] Zigzag Conversion
#


# @lc code=start
from collections import defaultdict


class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # "PAYPALISHIRING"
        # numRows = 4
        # 0,1,2,3,2,1,0,1,2,3 ...

        if numRows == 1:
            return s

        n = len(s)
        chars = defaultdict(str)
        dx = 1
        curr_row = 0

        for i in range(n):
            if curr_row == 0:
                dx = 1
            elif curr_row == numRows - 1:
                dx = -1

            chars[curr_row] += s[i]
            curr_row += dx

        return "".join([chars[x] for x in range(numRows)])


# @lc code=end
