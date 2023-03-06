#
# @lc app=leetcode id=198 lang=python3
#
# [198] House Robber
#

# @lc code=start
class Solution:
    # def rob(self, nums: List[int]) -> int:
    #     # bottom up dp

    #     n = len(nums)
    #     dp = [0] * (n + 1)
    #     dp[1] = nums[0]
        
    #     for i in range(1, n):
    #         dp[i + 1] = max(dp[i - 1] + nums[i], dp[i])
        
    #     return dp[n]

    def rob(self, nums: List[int]) -> int:
        # bottom up dp with O(1) space
        prev1, prev2 = 0, 0
        
        for i in range(len(nums)):
            temp = max(prev1 + nums[i], prev2)
            prev1 = prev2
            prev2 = temp
        
        return prev2
        
# @lc code=end

