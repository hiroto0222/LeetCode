#
# @lc app=leetcode id=290 lang=python3
#
# [290] Word Pattern
#


# @lc code=start
class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        # keep track of char -> word using a hashmap
        # abba -> dog dog dog dog -> false
        # O(N) time, O(N) space

        s = s.split(" ")

        if len(s) != len(pattern):
            return False

        dic = {}
        seen = set()
        for i, c in enumerate(pattern):
            if c in dic and dic[c] != s[i]:
                return False
            if c not in dic and s[i] in seen:
                return False

            dic[c] = s[i]
            seen.add(s[i])

        return True


# @lc code=end
