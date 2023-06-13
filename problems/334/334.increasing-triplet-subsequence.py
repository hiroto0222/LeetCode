#
# @lc app=leetcode id=334 lang=python3
#
# [334] Increasing Triplet Subsequence
#


# @lc code=start
class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        # i < j < k and nums[i] < nums[j] < nums[k]
        # greedy

        first, second = float("inf"), float("inf")
        for third in nums:
            if third > second:
                return True

            if third > first:
                second = third
            else:
                first = third

        return False


# @lc code=end
