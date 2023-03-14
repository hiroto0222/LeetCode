#
# @lc app=leetcode id=424 lang=python3
#
# [424] Longest Repeating Character Replacement
#

# @lc code=start
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        # choose k characters and change to any letter
        # return length of longest substring containing same letters
        # sliding window
        # "ABAB", k = 2 -> "AAAA"
        # "AABABBA", k = 2 -> "AABABBA"
        # if curr_window >= max_freq_letters + k -> shift window

        l = 0
        curr_max_cnt = 0
        max_len = 0
        cnts = {}

        for r, char in enumerate(s):
            cnts[char] = cnts.get(char, 0) + 1
            curr_max_cnt = max(curr_max_cnt, cnts[char])

            while r - l + 1 > curr_max_cnt + k:
                cnts[s[l]] -= 1
                l += 1
            
            max_len = max(max_len, r - l + 1)
        
        return max_len
        
# @lc code=end

