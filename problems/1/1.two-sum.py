#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # find pair of integers that add up to target
        # nums = [2, 7, 11, 5], target = 9
        # for each val, store in hashmap (target - nums[i] -> i)

        seen = {}
        for i, val in enumerate(nums):
            if val in seen:
                return [seen[val], i]
            seen[target - val] = i

        
# @lc code=end
