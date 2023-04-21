#
# @lc app=leetcode id=410 lang=python3
#
# [410] Split Array Largest Sum
#


# @lc code=start
import math


class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        n = len(nums)
        dp = {}

        prefix_sum = [0] * (n + 1)
        for i in range(n):
            prefix_sum[i + 1] = prefix_sum[i] + nums[i]

        def helper(i, k):
            if k == 1:
                return prefix_sum[n] - prefix_sum[i]

            if (i, k) in dp:
                return dp[(i, k)]

            res, currSum = math.inf, 0
            for j in range(i, n - k + 1):
                currSum += nums[j]
                maxSum = max(currSum, helper(j + 1, k - 1))
                res = min(res, maxSum)
                if currSum > res:
                    break

            dp[(i, k)] = res
            return res

        return helper(0, k)


# @lc code=end
