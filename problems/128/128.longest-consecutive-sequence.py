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
        # using a hashset
        num_set = set(nums)
        longest_seq = 0

        for num in num_set:
            if num - 1 not in num_set: # check if beginning of seq
                curr_seq = 1
                curr_num = num
                while curr_num + 1 in num_set:
                    curr_seq += 1
                    curr_num += 1
                
                longest_seq = max(curr_seq, longest_seq)
        
        return longest_seq


# @lc code=end

