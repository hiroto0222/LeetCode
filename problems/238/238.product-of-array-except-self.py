#
# @lc app=leetcode id=238 lang=python3
#
# [238] Product of Array Except Self
#


# @lc code=start
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # nums = [1,2,3,4]
        # prefix_prod = [1,2,6,24]
        # suffix_prod = [24,24,12,4]
        # for nums[i] -> prefix_prod[i - 1] * suffix_prod[i + 1]

        n = len(nums)
        res = []
        for i in range(0, n):
            prefix = res[i - 1] if i > 0 else 1
            res.append(prefix * nums[i])

        # [1,2,6,24]
        suffix = 1
        for i in range(n - 1, -1, -1):
            prefix = res[i - 1] if i > 0 else 1
            res[i] = prefix * suffix
            suffix *= nums[i]

        return res


# @lc code=end
