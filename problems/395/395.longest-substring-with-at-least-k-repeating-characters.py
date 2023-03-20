#
# @lc app=leetcode id=395 lang=python3
#
# [395] Longest Substring with At Least K Repeating Characters
#

# @lc code=start
from collections import defaultdict

class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        # divide and conquer

        if k == 1:
            return len(s)
        
        def helper(start, end):
            if start >= end:
                return 0
            
            cnts = defaultdict(int)
            for i in range(start, end + 1):
                cnts[s[i]] += 1
            
            for i in range(start, end + 1):
                curr = s[i]
                if cnts[curr] < k:
                    return max(helper(start, i - 1), helper(i + 1, end))
            
            return end - start + 1

        return helper(0, len(s) - 1)

        
# @lc code=end
