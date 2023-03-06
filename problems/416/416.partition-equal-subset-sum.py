#
# @lc app=leetcode id=416 lang=python
#
# [416] Partition Equal Subset Sum
#

# @lc code=start
class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if sum(nums) % 2 != 0:
            return False

        target = sum(nums) // 2
        seen_sums = set([0])

        for i in range(len(nums) - 1, -1, -1):
            curr = list(seen_sums)
            for seen in curr:
                if seen + nums[i] == target:
                    return True
                seen_sums.add(seen + nums[i])
        
        return False
    
        
# @lc code=end

