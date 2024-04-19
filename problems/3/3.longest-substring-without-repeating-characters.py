#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#


# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # s = "abcabcbb"
        # sliding window
        # set to keep track of current characters in window
        # time O(N), space O(1)

        n = len(s)

        if n == 0:
            return 0

        curr_max = 1
        curr_chars = set()
        l = 0

        for r in range(n):
            curr = s[r]
            while curr in curr_chars:
                curr_chars.remove(s[l])
                l += 1

            curr_chars.add(curr)
            curr_max = max(curr_max, r - l + 1)

        return curr_max


# @lc code=end
