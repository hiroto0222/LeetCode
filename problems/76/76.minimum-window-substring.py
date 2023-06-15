#
# @lc app=leetcode id=76 lang=python3
#
# [76] Minimum Window Substring
#

# @lc code=start
from collections import Counter, defaultdict


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # return the minimum window substring of s such that
        # every character in t (including duplicates) is included in the window
        # ie:
        # s = "ABBBBABC", t = "ABC"

        if not t or not s:
            return ""

        required_chars = Counter(t)
        curr_chars = 0
        curr_window = defaultdict(int)

        res = (float("inf"), -1, -1)
        l, r = 0, 0

        while r < len(s):
            curr_char = s[r]
            curr_window[curr_char] += 1

            if (
                curr_char in required_chars
                and curr_window[curr_char] == required_chars[curr_char]
            ):
                curr_chars += 1

            while l <= r and curr_chars == len(required_chars):
                left_char = s[l]

                if r - l + 1 < res[0]:
                    res = (r - l + 1, l, r)

                curr_window[left_char] -= 1
                if (
                    left_char in required_chars
                    and curr_window[left_char] < required_chars[left_char]
                ):
                    curr_chars -= 1

                l += 1

            r += 1

        return "" if res[0] == float("inf") else s[res[1] : res[2] + 1]


# @lc code=end
