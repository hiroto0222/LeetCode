#
# @lc app=leetcode id=274 lang=python3
#
# [274] H-Index
#


# @lc code=start
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # citations = [3,0,6,1,5]
        # 3, 6, 5 >= 3, hence h-index = 3
        # approach:
        # sort citations in reverse -> [6,5,3,1,0]
        # check if citations[i] >= i + 1
        # if -> continue
        # else -> return i

        n = len(citations)
        citations.sort(reverse=True)

        if citations[-1] >= n:
            return n

        for i, val in enumerate(citations):
            if val < i + 1:
                return i


# @lc code=end
