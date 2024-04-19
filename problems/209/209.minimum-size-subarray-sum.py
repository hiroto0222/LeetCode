#
# @lc app=leetcode id=209 lang=python3
#
# [209] Minimum Size Subarray Sum
#


# @lc code=start


class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        # minimal length of subarray where sum >= target
        # sliding window
        # [2,3,7] target = 7
        # [1,2,3,4,5] target = 11
        # time O(N), space O(1)
        # the "l" pointer only moves at most N times throughout
        # the entire iteration of "r" = [0, N]
        # thus time complexity is of O(N)

        n = len(nums)
        l = 0
        curr_min = float("inf")
        curr_sum = 0

        for r in range(n):
            curr_sum += nums[r]
            while curr_sum >= target:
                curr_min = min(curr_min, r - l + 1)
                curr_sum -= nums[l]
                l += 1

        return 0 if curr_min == float("inf") else curr_min


# @lc code=end
