#
# @lc app=leetcode id=392 lang=python3
#
# [392] Is Subsequence
#


# @lc code=start
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        # check if s is a subsequence of t
        # s = "abc", t = "ahbgdc"
        # 2 pointers

        if not s:
            return True

        if not t:
            return False

        idx = 0
        for c in t:
            if c == s[idx]:
                idx += 1

            if idx == len(s):
                return True

        return False


# @lc code=end
