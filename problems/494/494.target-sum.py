#
# @lc app=leetcode id=494 lang=python3
#
# [494] Target Sum
#

# @lc code=start
class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        # using memoization

        dp = {} # (index, total) -> # of ways

        def compute(i, total):
            if i >= len(nums):
                return 1 if total == target else 0
            
            if (i, total) in dp:
                return dp[(i, total)]
            
            dp[(i, total)] = compute(i + 1, total + nums[i]) + compute(i + 1, total - nums[i])

            return dp[(i, total)]
        
        return compute(0, 0)
    

# @lc code=end

