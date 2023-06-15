#
# @lc app=leetcode id=274 lang=python3
#
# [274] H-Index
#


# @lc code=start
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # h-index -> max val of h such that author has published
        #            at least h papers that have been cited at least h times
        # ie:
        # citations = [3, 0, 6, 1, 5]
        #
        # observations:
        # 1. max val of h is n

        # approach 1:
        # 1. start from h = n
        # 2. iterate until we find possible h
        # O(N^2) time -> 10^6

        # n = len(citations)
        # for h in range(n, -1, -1):
        #     cnt = 0
        #     for val in citations:
        #         if val >= h:
        #             cnt += 1

        #     if cnt >= h:
        #         return h

        # approach 2:
        # 1. sort the array in reverse order [3, 0, 6, 1, 5] O(NlogN)
        #    -> citations = [6, 5, 3, 1, 0]
        # 2. for each val[i], compare with i + 1
        #    - if val[i] >= i + 1 -> curr max is i + 1
        #    - if val[i] < i + 1 -> return i
        # O(NlogN) time

        n = len(citations)
        citations.sort(reverse=True)

        if citations[-1] >= n:
            return n

        for i, val in enumerate(citations):
            if val < i + 1:
                return i


# @lc code=end
