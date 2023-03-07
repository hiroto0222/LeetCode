#
# @lc app=leetcode id=128 lang=python
#
# [128] Longest Consecutive Sequence
#

# @lc code=start
class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # length of longest consecutive elements sequence
        # nums = [100, 4, 200, 1, 3, 2] -> [1, 2, 3, 4] -> 4
        # create initial set of all vals
        # 100 -> 99, 101
        # O(N) time, O(N) space

        if len(nums) == 0:
            return 0
        
        ans = 1
        hash = set(nums)
        for val in hash:
            if val - 1 in hash:
                continue

            curr_seq = 1
            while val + 1 in hash:
                curr_seq += 1
                val += 1
            ans = max(curr_seq, ans)
        
        return ans


# @lc code=end
