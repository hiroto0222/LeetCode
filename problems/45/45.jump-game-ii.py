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
        # BFS using sliding window
        # time O(N), space O(1)

        n = len(nums)
        res = 0
        l, r = 0, 0

        while r < n - 1:
            max_reach = 0
            for i in range(l, r + 1):
                max_reach = max(max_reach, i + nums[i])

            # update window
            l = r + 1
            r = max_reach

            if l > r:
                return -1

            res += 1

        return res

    # def jump(self, nums: List[int]) -> int:
    #     # nums = [2,3,1,1,4]
    #     # initial approach
    #     # keep track of min jumps to reach end starting from end
    #     # update the current min jumps to reach end from current
    #     # time O(N^2), space O(N)

    #     n = len(nums)
    #     dp = [0 for _ in range(n)]

    #     for i in range(n - 2, -1, -1):
    #         reach = min(n, nums[i] + i + 1)
    #         curr_min = math.inf
    #         for j in range(i + 1, reach):
    #             curr_min = min(curr_min, dp[j] + 1)
    #         dp[i] = curr_min

    #     return dp[0]


# @lc code=end
