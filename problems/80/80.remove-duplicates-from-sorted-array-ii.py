#
# @lc app=leetcode id=80 lang=python3
#
# [80] Remove Duplicates from Sorted Array II
#


# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        # given sorted array in non-decreasing order
        # remove duplicates in-place such that they only appear at most twice
        # ie:
        # nums = [1, 1, 1, 2, 2, 3]
        # -> nums = [1, 1, 2, 2, 3, _]
        # keep track of idx to replace
        # only check 2 indexes before

        k = 0

        for val in nums:
            if k < 2 or val > nums[k - 2]:
                nums[k] = val
                k += 1

        return k


# @lc code=end
