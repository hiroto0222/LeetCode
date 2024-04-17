#
# @lc app=leetcode id=45 lang=python3
#
# [45] Jump Game II
#


# @lc code=start
import math


class Solution:
    def jump(self, nums: List[int]) -> int:
        # nums = [2,3,1,1,4]
        # initial approach
        # keep track of min jumps to reach end starting from end
        # update the current min jumps to reach end from current
        # time O(N^2), space O(N)

        n = len(nums)
        dp = [0 for _ in range(n)]

        for i in range(n - 2, -1, -1):
            reach = min(n, nums[i] + i + 1)
            curr_min = math.inf
            for j in range(i + 1, reach):
                curr_min = min(curr_min, dp[j] + 1)
            dp[i] = curr_min

        return dp[0]


# @lc code=end
