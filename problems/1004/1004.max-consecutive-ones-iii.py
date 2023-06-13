#
# @lc app=leetcode id=1004 lang=python3
#
# [1004] Max Consecutive Ones III
#


# @lc code=start
class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        l = 0
        for r in range(len(nums)):
            if nums[r] == 0:
                k -= 1

            if k < 0:
                if nums[l] == 0:
                    k += 1
                l += 1

        return r - l + 1


# @lc code=end
