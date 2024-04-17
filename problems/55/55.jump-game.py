#
# @lc app=leetcode id=55 lang=python3
#
# [55] Jump Game
#


# @lc code=start
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # nums = [2,3,1,1,4]
        # start from end
        # if can reach current position, then move goal k
        # if goal k reaches start, then can reach end
        # nums = [2,3,2,0,1,4]

        n = len(nums)
        k = n - 1
        for i in range(n - 2, -1, -1):
            if nums[i] + i >= k:
                k = i

        return k == 0


# @lc code=end
