#
# @lc app=leetcode id=1011 lang=python3
#
# [1011] Capacity To Ship Packages Within D Days
#


# @lc code=start
from functools import cache


class Solution:
    # def shipWithinDays(self, weights: List[int], days: int) -> int:
    #     """
    #     return least weight capacity ship such that
    #     all packages can be shipped <= days
    #
    #     O(N^2 * K)
    #     """
    #     n = len(weights)

    #     if not weights:
    #         return 0

    #     if days >= n:
    #         return max(weights)

    #     @cache
    #     def dfs(i, k):
    #         if i >= n:
    #             return 0

    #         if k == 1:
    #             return sum(weights[i:])

    #         res = float("inf")
    #         curr = 0
    #         curr_weight = 0
    #         for i in range(i, n - k + 1):
    #             curr_weight += weights[i]
    #             curr = max(curr_weight, dfs(i + 1, k - 1))
    #             res = min(res, curr)

    #         return res

    #     return dfs(0, days)

    def shipWithinDays(self, weights: List[int], days: int) -> int:
        """
        return least weight capacity ship such that
        all packages can be shipped <= days

        we know
        max(weights) <= res <= sum(weights)
        binary search where:
        1. if can partition weights such that each partition < mid
            then r = mid
        2. else l = mid

        O(N) to check if can partition
        O(Lg N) for BS
        -> O(NlgN)
        """
        l, r = max(weights), sum(weights)

        def check(capacity):
            curr_weight = 0
            curr_days = 1
            for weight in weights:
                curr_weight += weight
                if curr_weight > capacity:
                    curr_weight = weight
                    curr_days += 1
                if curr_days > days:
                    return False

            return True

        while l < r:
            capacity = (l + r) // 2

            if check(capacity):
                r = capacity
            else:
                l = capacity + 1

        return l


# @lc code=end
