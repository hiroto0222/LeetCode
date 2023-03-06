#
# @lc app=leetcode id=217 lang=python3
#
# [217] Contains Duplicate
#

# @lc code=start
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        # nums = [1, 2, 3, 1] -> True
        # nums = [1, 2, 3, 4] -> False
        # use a hashset, storing seen values
        # O(N) time, O(N) space

        seen = set()
        for val in nums:
            if val in seen:
                return True
            seen.add(val)
        
        return False


# @lc code=end

