#
# @lc app=leetcode id=11 lang=python3
#
# [11] Container With Most Water
#


# @lc code=start
class Solution:
    def maxArea(self, height: List[int]) -> int:
        # max amount of water container can store
        # height = [1,8,6,2,5,4,8,3,7]
        #             s             e
        # area -> min(height[l], height[r]) * (r - l)
        # 2 pointers
        # keep track of current max water
        # which ever side is shorter, move
        # time O(N), space O(1)

        n = len(height)
        l, r = 0, n - 1
        curr_max = 0
        while l < r:
            curr = min(height[l], height[r]) * (r - l)
            curr_max = max(curr, curr_max)

            if height[l] <= height[r]:
                l += 1
            else:
                r -= 1

        return curr_max


# @lc code=end
