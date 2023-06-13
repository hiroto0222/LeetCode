#
# @lc app=leetcode id=1456 lang=python3
#
# [1456] Maximum Number of Vowels in a Substring of Given Length
#


# @lc code=start
class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        vowels = "aeiou"
        curr_max = 0
        for i in range(k):
            if s[i] in vowels:
                curr_max += 1

        curr_cnt = curr_max
        for r in range(k, len(s)):
            if s[r - k] in vowels:
                curr_cnt -= 1
            if s[r] in vowels:
                curr_cnt += 1

            curr_max = max(curr_max, curr_cnt)

        return curr_max


# @lc code=end
