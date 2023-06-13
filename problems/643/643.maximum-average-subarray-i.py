#
# @lc app=leetcode id=643 lang=python3
#
# [643] Maximum Average Subarray I
#


# @lc code=start
class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        curr_sum = sum(nums[:k])
        curr_max = curr_sum / k

        for r in range(k, len(nums)):
            curr_sum -= nums[r - k]
            curr_sum += nums[r]
            curr_max = max(curr_max, curr_sum / k)

        return curr_max


# @lc code=end
