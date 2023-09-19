#
# @lc app=leetcode id=1732 lang=python3
#
# [1732] Find the Highest Altitude
#


# @lc code=start
class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        # n + 1 points at different altitudes
        # starts from 0
        # prefix sum

        curr_max = 0
        curr = 0
        for val in gain:
            curr += val
            curr_max = max(curr_max, curr)

        return curr_max


# @lc code=end
