#
# @lc app=leetcode id=16 lang=python
#
# [16] 3Sum Closest
#

# @lc code=start
class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) < 3: return 0

        nums.sort()
        closest = float('inf')
        for i in range(len(nums) - 2):
            a = nums[i]
            l, r = i + 1, len(nums) - 1
            while l < r:
                curr_sum = a + nums[l] + nums[r]
                if abs(target - curr_sum) < abs(target - closest):
                    closest = curr_sum
                
                if curr_sum < target: l += 1
                elif curr_sum > target: r -= 1
                else: return target
        
        return closest
        
# @lc code=end

