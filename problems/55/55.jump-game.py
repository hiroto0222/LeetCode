#
# @lc app=leetcode id=55 lang=python3
#
# [55] Jump Game
#


# @lc code=start
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        # nums = [2,3,1,1,4]
        # start from i = 0
        # recursive dp
        # keep track if curr position is reachable

        n = len(nums)
        dp = [False for _ in range(n)]
        dp[0] = True

        for i in range(1, n):
            # for curr position check if reachable by previous
            for j in range(i - 1, -1, -1):
                if nums[j] >= i - j and dp[j]:
                    # then reachable
                    dp[i] = True
                    break

        return dp[-1]


# @lc code=end
