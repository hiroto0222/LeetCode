#
# @lc app=leetcode id=151 lang=python3
#
# [151] Reverse Words in a String
#


# @lc code=start
class Solution:
    def reverseWords(self, s: str) -> str:
        res = s.split()
        res.reverse()
        return " ".join(res)


# @lc code=end
