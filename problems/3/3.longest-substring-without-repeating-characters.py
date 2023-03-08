#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # find the length of longest substring without repeating chars
        # sliding window, for each window have hashset of seen
        # s = "dvdf"

        if len(s) == 0:
            return 0

        l = 0
        ans = 0
        seen = set()

        for r, char in enumerate(s):
            if char not in seen:
                seen.add(char)
            else:
                while s[l] != char:
                    seen.remove(s[l])
                    l += 1
                l += 1
            ans = max(ans, r - l + 1)
        
        return ans
        
# @lc code=end
