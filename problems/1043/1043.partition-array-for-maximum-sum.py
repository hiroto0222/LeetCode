#
# @lc app=leetcode id=1043 lang=python3
#
# [1043] Partition Array for Maximum Sum
#


# @lc code=start
from functools import cache


class Solution:
    def maxSumAfterPartitioning(self, arr, k):
        """
        eg:
        arr = [1,15,7 | 9 | 2,5,10], k = 3
        arr = [15,15,15,9,10,10,10]

        1. try every possible partition from i
        2. take the best partition

        f(i) -> gives max partition sum from i
        """
        n = len(arr)

        @cache
        def helper(i):
            if i == n:
                return 0

            currMax = 0
            sumMax = 0
            for j in range(k):
                part = i + j
                if part >= n:
                    break
                currMax = max(currMax, arr[part])
                leftPart = currMax * (j + 1)
                rightPartMax = helper(part + 1)
                sumMax = max(sumMax, leftPart + rightPartMax)

            return sumMax

        return helper(0)


# @lc code=end
