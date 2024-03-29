#
# @lc app=leetcode id=238 lang=python3
#
# [238] Product of Array Except Self
#


# @lc code=start
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # nums = [1, 2, 3, 4]
        # pre = [1, 2, 6, 24]
        # suf = [24, 24, 12, 4]

        n, ans, suf = len(nums), [1] * len(nums), 1
        for i in range(1, n):
            ans[i] = ans[i - 1] * nums[i - 1]
        for i in range(n - 1, -1, -1):
            ans[i] *= suf
            suf *= nums[i]

        return ans


# @lc code=end
